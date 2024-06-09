package com.example.blog.controller;

import com.example.blog.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("users", new User());
        return "/users/signIn";
    }

    @GetMapping("/index")
    public String welcome(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/users/signIn";
        }
        return "index";
    }
}
