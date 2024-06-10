package com.example.blog.service;

import com.example.blog.mapper.TagMapper;
import com.example.blog.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public Tag findByName(String name) {
        return tagMapper.findByName(name);
    }

    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    public void save(Tag tag) {
        tagMapper.save(tag);
    }
}
