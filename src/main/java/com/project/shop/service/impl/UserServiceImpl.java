package com.project.shop.service.impl;

import com.project.shop.common.Result;
import com.project.shop.entity.pojo.Page;
import com.project.shop.entity.pojo.User;
import com.project.shop.mapper.UserMapper;
import com.project.shop.service.UserService;
import com.project.shop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.shop.util.EncryptUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page findUserData(Integer pageNum,Integer pageSize,Integer mode){
        int offset = (pageNum - 1) * pageSize;
        List<User> list = userMapper.findUserData(offset,pageSize,mode);
        long total = userMapper.getUserCount(mode);
        Page<User> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setList(list);
        page.setTotal(total);
        return page;
    }

    @Override
    public  int updateUserData(User user){return userMapper.updateUserData(user);}

    @Override
    public  int addUserData(User user){return  userMapper.addUserData(user);}

    @Override
    public int delUserData(Integer id){return  userMapper.delUserData(id);}

    @Override
    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (!EncryptUtils.verifyPassword(password,user.getPassword(),user.getSalt())) {
            throw new RuntimeException("密码错误");
        }
        if (user.getPower() == 3){
            throw new RuntimeException("权限不足");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("username",user.getUsername());
        claims.put("power",user.getPower());
        return JwtUtil.genToken(claims);
    }
}
