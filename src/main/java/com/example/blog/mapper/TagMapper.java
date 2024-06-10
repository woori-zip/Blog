package com.example.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    List<String> findAll();
    void save(String tag);
    void delete(String tag);
}
