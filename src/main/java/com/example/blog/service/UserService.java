package com.example.blog.service;

import com.example.blog.mapper.UserMapper;
import com.example.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Autowired
    private UserMapper userMapper; // UserMapper 주입

    public boolean signUp(User user) {
        if(existById(user.getId()) || existByEmail(user.getEmail())) {
            return false;
        }
        userMapper.save(user);
        return true;
    }

    public boolean existById(String id) {
        return userMapper.findById(id) != null;
    }

    public boolean existByEmail(String email) {
        return userMapper.findByEmail(email) != null;
    }

    public User signIn(String id, String password) {
        // 사용자가 입력한 id, pw 를 받아 로그인 시도.

        User user = userMapper.findById(id);
        // 주어진 id로 사용자를 찾음.
        // 찾은 사용자는 "user" 변수에 저장

        if(user != null && user.getPassword().equals(password)) {
            // 사용자가 존재하고, 비밀번호가 일치하는지 확인
            return user;
        }
        return null;
    }

}
