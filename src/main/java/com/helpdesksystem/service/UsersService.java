package com.helpdesksystem.service;

import com.helpdesksystem.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UsersService extends IService<Users> {

    boolean registerUser(Users user);

    String loginUser(String username, String password);

    // 获取所有用户
    List<Users> getAllUsers();

    // 根据ID获取用户
    Users getUserById(Integer userId);

    // 更新用户信息
    boolean updateUser(Users user);

    // 删除用户
    boolean deleteUser(Integer userId);

    // 根据用户名查找用户
    Users findByUsername(String username);

    // 检查用户名是否存在
    boolean isUsernameExists(String username);

    // 检查邮箱是否存在
    boolean isEmailExists(String email);
}
