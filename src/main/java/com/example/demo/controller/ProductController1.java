package com.example.demo.controller;

import com.example.demo.Model.Productt;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController1 {
    @GetMapping("product/form")
    public String form(Model model) {
        Productt productt = new Productt();
        productt.setName("Đạt");
        productt.setPrice(11.99);
        model.addAttribute("p1", productt);
        return "Lab2/formProduct";
    }

    @PostMapping("/product/save1")
    public String save1(@ModelAttribute("p2") Productt p) {
        return "Lab2/formProduct";
    }

   @ModelAttribute("items")
    public List<Productt> getProducts() {
        return Arrays.asList(
                new Productt("1",1.11),
                new Productt("2",2.22)
        );
   }

}
