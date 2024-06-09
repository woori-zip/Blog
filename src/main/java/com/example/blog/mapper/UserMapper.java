package com.example.blog.mapper;

import com.example.blog.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findById(String id);
    User findByEmail(String email);
    void save(User user);
}