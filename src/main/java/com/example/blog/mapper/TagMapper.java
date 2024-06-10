package com.example.blog.mapper;

import com.example.blog.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMapper {
    Tag findByName(String name);
    List<Tag> findAll();
    void save(Tag tag);
}
