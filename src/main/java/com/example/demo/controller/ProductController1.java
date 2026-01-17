package com.example.demo.controller;

import Model.Product;
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
        Product product = new Product();
        product.setName("Đạt");
        product.setPrice(11.99);
        model.addAttribute("p1", product);
        return "Lab2/formProduct";
    }

    @PostMapping("/product/save1")
    public String save1(@ModelAttribute("p2") Product p) {
        return "Lab2/formProduct";
    }

   @ModelAttribute("items")
    public List<Product> getProducts() {
        return Arrays.asList(
                new Product("1",1.11),
                new Product("2",2.22)
        );
   }

}
