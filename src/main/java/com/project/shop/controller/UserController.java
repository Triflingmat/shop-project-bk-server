package com.project.shop.controller;

import com.project.shop.common.Result;
import com.project.shop.entity.pojo.Page;
import com.project.shop.entity.pojo.User;
import com.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.shop.util.EncryptUtils;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    //查找用户数据
    @GetMapping("/user/list")
    public Result<Page<User>> findUserData(
            @RequestParam(defaultValue = "1")Integer pageNum,
            @RequestParam(defaultValue = "15")Integer pageSize,
            @RequestParam(defaultValue = "0")Integer mode){
        try{
            Page<User> page = userService.findUserData(pageNum,pageSize,mode);
            return Result.success(page);
        }catch (RuntimeException e){
            return Result.fail(e.getMessage());
        }
    }
    //更改用户数据
    @PutMapping("/user/update")
    public Result<User> updateUserData(@RequestBody User user){
        String salt = EncryptUtils.generateSalt();
        String password = EncryptUtils.sha256HashWithSalt(user.getPassword(),salt);
        user.setPassword(password);
        user.setSalt(salt);
        int updateUser = userService.updateUserData(user);
        if (updateUser==0){
            return Result.fail("发生错误");
        }
        return Result.success(user);
    }
    //增加用户数据
    @PostMapping("/user/add")
    public  Result<User> addUserData(@RequestBody User user){
        String salt = EncryptUtils.generateSalt();
        String hashPassword =  EncryptUtils.sha256HashWithSalt(user.getPassword(),salt);
        user.setPassword(hashPassword);
        int addUser = userService.addUserData(user);
        if (addUser==0){
            return Result.fail("发生错误");
        }
        return Result.success(user);
    }

    //删除用户数据
    @DeleteMapping("/user/del/{id}")
    public  Result<User> delUserData(@PathVariable Integer id){
        int delUser = userService.delUserData(id);
        if (delUser==0){
            return Result.fail("发生错误");
        }
        return Result.success(null);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody User user){
        try {
            String token = userService.login(user.getUsername(),user.getPassword());
            return Result.success(token);
        }catch (RuntimeException e){
            return  Result.fail(e.getMessage());
        }
    }

}
