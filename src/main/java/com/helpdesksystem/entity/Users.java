package com.helpdesksystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@TableName("Users")
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @TableId(type = IdType.AUTO)
    private Integer user_id;

    private String Username;

    private String Password;

    private String Email;

    private String Role;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime created_at;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updated_at;
}
