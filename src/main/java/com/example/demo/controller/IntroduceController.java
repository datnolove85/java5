package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceController {
   @RequestMapping("introduce")
    public String introduce(Model model) {
   model.addAttribute("message", "Hello World");
   model.addAttribute("name", " Đạt No Love");
   model.addAttribute("age", 18);
   return "introduce";
    }

}
