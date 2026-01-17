package com.example.demo.controller;

import Model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/form")
    public String form() {
        return "Lab2/form";
    }

    @PostMapping("/product/save")
    public String save(Product product, Model model) {
        model.addAttribute("name", product.getName());
        model.addAttribute("price", product.getPrice());
        return "Lab2/form";
    }
}
