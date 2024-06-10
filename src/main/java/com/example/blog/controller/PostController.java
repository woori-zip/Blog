package com.example.blog.controller;

import com.example.blog.model.Post;
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
    public String list(@RequestParam(value = "tag", required = false) String tag, Model model) {
        List<Post> posts = postService.findAll(tag);
        model.addAttribute("posts", posts);
        model.addAttribute("tags", tagService.findAll()); // 동적으로 태그 목록을 가져옴
        return "post/list";
    }


    @GetMapping("/create")
    public String createForm(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user"); // 세션에서 로그인된 사용자 정보를 가져옴
        if(user == null) {
            return "${pageContext.request.contextPath}/users/signin";
        }
        model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/create")
    public String createPost(Post post, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if(user == null) {
            return "${pageContext.request.contextPath}/users/signin";
        }
        post.setAuthor(user.getId());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        postService.createPost(post);
        return "redirect:/post/list";
    }
}
