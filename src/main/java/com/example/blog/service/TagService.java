package com.example.blog.service;

import com.example.blog.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagMapper tagMapper;

    public List<String> findAll() {
        return tagMapper.findAll();
    }

    public void save(String tag) {
        tagMapper.save(tag);
    }

    public void delete(String tag) {
        tagMapper.delete(tag);
    }
}
