package com.example.blog.service;

import com.example.blog.mapper.PostMapper;
import com.example.blog.mapper.TagMapper;
import com.example.blog.model.Post;
import com.example.blog.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostMapper postMapper;

    public List<Post> findAll(String tag) {
        return postMapper.findAll(tag);
    }

    public void createPost(Post post) {
        postMapper.save(post);
    }
}
