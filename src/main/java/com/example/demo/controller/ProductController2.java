package com.example.demo.controller;

import com.example.demo.Model.Productt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController2 {

    @RequestMapping("/form")
    public String form() {
        return "Lab2/form";
    }

    @PostMapping("/product/save")
    public String save(Productt productt, Model model) {
        model.addAttribute("name", productt.getName());
        model.addAttribute("price", productt.getPrice());
        return "Lab2/form";
    }
}
