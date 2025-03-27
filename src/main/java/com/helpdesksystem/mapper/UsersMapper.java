package com.helpdesksystem.mapper;

import com.helpdesksystem.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper extends BaseMapper<Users> {
    // 可以在这里添加自定义的查询方法

    /**
     * 插入用户并自动设置时间戳
     * @param user 用户实体对象
     * @return 影响的行数
     */
    @Insert("INSERT INTO Users (Username, Password, Email, Role, created_at, updated_at) " +
           "VALUES (#{Username}, #{Password}, #{email}, #{Role}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
    int insertWithTime(Users user);

    /**
     * 更新用户并自动更新时间戳
     * @param user 用户实体对象
     * @return 影响的行数
     */
    @Update("UPDATE Users SET Username = #{Username}, Password = #{Password}, " +
           "email = #{email}, role = #{role}, " +
           "updated_at = CURRENT_TIMESTAMP WHERE id = #{id}")
    int updateWithTime(Users user);
}
