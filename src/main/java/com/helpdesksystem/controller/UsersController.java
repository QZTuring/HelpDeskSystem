package com.helpdesksystem.controller;

import com.helpdesksystem.entity.Users;
import com.helpdesksystem.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id) {
        Users user = usersService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // 用户注册接口
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        boolean isRegistered = usersService.registerUser(user);
        if (isRegistered) {
            return ResponseEntity.ok("用户注册成功");
        } else {
            return ResponseEntity.badRequest().body("用户注册失败");
        }
    }

    // 用户登录接口
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        String token = usersService.loginUser(user.getUsername(), user.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("用户名或密码错误");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody Users user) {
        user.setUser_id(id);
        boolean isUpdated = usersService.updateUser(user);
        if (isUpdated) {
            return ResponseEntity.ok("用户更新成功");
        } else {
            return ResponseEntity.badRequest().body("用户更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        boolean isDeleted = usersService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("用户删除成功");
        } else {
            return ResponseEntity.badRequest().body("用户删除失败");
        }
    }
}
