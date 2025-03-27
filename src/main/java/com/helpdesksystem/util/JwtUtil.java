package com.helpdesksystem.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    // 用于签署 JWT 的密钥
    private static final String SECRET_KEY = "your_secret_key";

    // 生成 JWT 令牌的方法
    @SuppressWarnings("deprecation")
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // 设置令牌的主题
                .setIssuedAt(new Date()) // 设置签发日期
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 设置过期时间（10小时）
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 使用密钥签署令牌
                .compact();
    }

    // 验证 JWT 令牌并提取用户名的方法
    @SuppressWarnings("deprecation")
    public static String validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // 设置用于验证的密钥
                .parseClaimsJws(token) // 解析令牌
                .getBody()
                .getSubject(); // 提取主题（用户名）
    }
}
