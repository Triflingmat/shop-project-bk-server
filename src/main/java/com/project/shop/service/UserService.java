package com.project.shop.service;

import com.project.shop.common.Result;
import com.project.shop.entity.pojo.Page;
import com.project.shop.entity.pojo.User;

import java.util.List;

public interface UserService {

    String login(String username, String password);

    User register(User user);

    Page findUserData(Integer pageNum, Integer pageSize,Integer mode);

    int updateUserData(User user);

    int addUserData(User user);

    int delUserData(Integer id);

    User findById(Integer id);

    void changePassword(Integer userId, String oldPassword, String newPassword);
}
