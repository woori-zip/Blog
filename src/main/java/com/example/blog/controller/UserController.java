package com.example.blog.controller;

import com.example.blog.model.User;
import com.example.blog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 웹 요청을 처리하는 Controller.
@RequestMapping("/users") // "/users"로 시작하는 URL 요청 처리.
public class UserController {

    @Autowired
    private UserService userService;
    // userService 변수를 통해 UserService 기능 사용 가능.

    @GetMapping("/signUp") // "/users/signUp" URL 로 GET 요청이 들어올 시 실행.
    public String signUpForm(Model model) {
        // Model model : 뷰에 데이터를 전달하는 데 사용.

        model.addAttribute("user", new User());
        // User 객체를 "users"라는 이름으로 model 에 추가.
        return "users/signUp";
    }

    @PostMapping("/signUp") // "/users/signUp" URL 로 POST 요청이 들어올 시 실행.
    public String signUp(User user, Model model) {
        // User user : 폼에서 전송된 사용자 정보를 담고 있음.
        // Model model : 에러 메시지를 뷰에 전달하기 위해 사용.

        if(userService.existById(user.getId())) { // 회원가입 성공
            model.addAttribute("error","Already Existed ID");
            return "users/signUp";
        } else if (userService.existByEmail(user.getEmail())){ // 회원가입 실패
            model.addAttribute("error","Already Existed Email");
            return "users/signUp";
        } else {
            userService.signUp(user);
            return "users/signIn";
        }
    }

    @GetMapping("/signIn") // "/users/signin" URL 로 GET 요청이 들어올 시 실행.
    public String signInForm(Model model) {
        model.addAttribute("user", new User());
        return "users/signIn";
    }

    @PostMapping("/signIn") // "/users/signin" URL 로 POST 요청이 들어올 시 실행.
    public String signIn(User user, HttpSession session, Model model) {
        // User user : 폼에서 전송된 사용자 정보를 담고 있음.
        // HttpSession session : 현재 사용자 세션. 로그인한 사용자의 정보 유지를 위해 사용.
        // Model model : 에러 메시지를 뷰에 전달하기 위해 사용.

        User loggedInUser = userService.signIn(user.getId(), user.getPassword());
        // 사용자가 입력한 id, pw 로 sing in 시도.
        // -> 성공: loggedInUser 에 사용자 정보 저장.
        // -> 실패: null 반환.

        if (loggedInUser != null) {
            session.setAttribute("user", loggedInUser);
            //로그인된 사용자 정보를 세션에 저장.
            return "index";
        } else {
            model.addAttribute("error", "Failed");
            return "users/signIn";
        }
    }
}
