package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.model.Tag;
import com.example.blog.model.User;
import com.example.blog.service.PostService;
import com.example.blog.service.TagService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "tag", required = false) String tag
            , Model model) {
        List<Post> posts = postService.findAll(tag);
        model.addAttribute("posts", posts);
        List<Tag> tags = tagService.findAll();
        model.addAttribute("tags", tags);
        model.addAttribute("selectedTag", tag);
        return "post/list";
    }

    @GetMapping("/create")
    public String createForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/users/signIn";
        }
        List<Tag> tags = tagService.findAll();
        model.addAttribute("post", new Post());
        model.addAttribute("tags", tags);
        return "post/create";
    }

    @PostMapping("/create")
    public String createPost(Post post
            , @RequestParam(value = "newTag", required = false) String newTag
            , HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/users/signIn";
        }

        if (newTag != null && !newTag.isEmpty()) {
            Tag tag = new Tag();
            tag.setName(newTag);
            tagService.save(tag);
            post.setTagId(tag.getId());
        } else {
            Tag existingTag = tagService.findByName(post.getTag());
            if (existingTag != null) {
                post.setTagId(existingTag.getId());
            }
        }
        post.setAuthor(user.getId());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        postService.createPost(post);
        return "redirect:/post/list";
    }
}
