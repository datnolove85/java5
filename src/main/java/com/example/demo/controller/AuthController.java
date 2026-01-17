package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class AuthController {

    @Autowired
    HttpServletRequest request;

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/check")
//    public String check(Model model) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if(username.equals("admin") && password.equals("123456")) {
//            model.addAttribute("message", "Đăng nhập thành công");
//        }else{
//            model.addAttribute("message","Đăng nhập không thành công");
//        }
//        return "form";
//    }

    public String check(Model model, @RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("123456")) {
            model.addAttribute("message", "Đăng nhập thành công");
        } else {
            model.addAttribute("message", "Đăng nhập không thành công");
        }
        return "form";
    }
}
