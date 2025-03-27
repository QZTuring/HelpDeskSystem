package com.helpdesksystem.service.impl;

import com.helpdesksystem.entity.Users;
import com.helpdesksystem.mapper.UsersMapper;
import com.helpdesksystem.service.UsersService;
import com.helpdesksystem.util.JwtUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    // 用于记录用户活动的日志记录器
    private static final Logger logger = LogManager.getLogger(UsersServiceImpl.class);

    // 注册新用户的方法
    public boolean registerUser(Users user) {
        logger.info("正在注册用户: " + user.getUsername());
        // 将用户保存到数据库
        return this.save(user);
    }

    // 用户登录并生成 JWT 令牌的方法
    public String loginUser(String username, String password) {
        logger.info("用户尝试登录: " + username);
        // 根据用户名和密码查询数据库
        Users user = this.lambdaQuery().eq(Users::getUsername, username).eq(Users::getPassword, password).one();
        if (user != null) {
            logger.info("用户登录成功: " + username);
            // 为认证通过的用户生成 JWT 令牌
            return JwtUtil.generateToken(username);
        }
        logger.warn("登录尝试失败: " + username);
        return null;
    }

    // 实现获取所有用户的方法
    @Override
    public List<Users> getAllUsers() {
        logger.info("正在获取所有用户");
        return this.list();
    }

    // 实现检查用户名是否存在的方法
    @Override
    public boolean isUsernameExists(String username) {
        logger.info("正在检查用户名是否存在: " + username);
        return this.lambdaQuery().eq(Users::getUsername, username).count() > 0;
    }

    public static Logger getLogger() {
        return logger;
    }

    @Override
    public Users getUserById(Integer userId) {
        // 待实现：根据ID获取用户
        throw new UnsupportedOperationException("未实现的方法 'getUserById'");
    }

    @Override
    public boolean updateUser(Users user) {
        // 待实现：更新用户信息
        throw new UnsupportedOperationException("未实现的方法 'updateUser'");
    }

    @Override
    public boolean deleteUser(Integer userId) {
        // 待实现：删除用户
        throw new UnsupportedOperationException("未实现的方法 'deleteUser'");
    }

    @Override
    public Users findByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    @Override
    public boolean isEmailExists(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmailExists'");
    }

    @Override
    public boolean save(Users user) {
        // 调用自定义的 insertWithTime 方法来插入用户数据
        // 该方法会自动设置 created_at 和 updated_at 为当前时间
        // 返回值 > 0 表示插入成功，转换为 boolean 类型返回
        return baseMapper.insertWithTime(user) > 0;
    }

    @Override
    public boolean updateById(Users user) {
        // 调用自定义的 updateWithTime 方法来更新用户数据
        // 该方法会自动更新 updated_at 为当前时间
        // 返回值 > 0 表示更新成功，转换为 boolean 类型返回
        return baseMapper.updateWithTime(user) > 0;
    }
}
