package com.example.blog.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {
    private int id;
    private String title;
    private String content;
    private int tagId;
    private String tag;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime  updatedAt;
}