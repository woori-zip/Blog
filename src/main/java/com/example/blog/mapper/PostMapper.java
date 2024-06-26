package com.example.blog.mapper;

import com.example.blog.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll(String tag);
    void save(Post post);
}
