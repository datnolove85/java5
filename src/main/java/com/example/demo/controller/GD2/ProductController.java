package com.example.demo.controller.GD2;

import com.example.demo.Model.Product;
import com.example.demo.Repo.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gd2/product")
public class ProductController {

    private final ProductRepository productRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("items", productRepo.findAll());
        return "gd2/product/index";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("product") Product product,
                       Errors errors,
                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("items", productRepo.findAll());
            return "gd2/product/index";
        }

        productRepo.save(product);
        return "redirect:/gd2/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product",
                productRepo.findById(id).orElse(new Product()));
        model.addAttribute("items", productRepo.findAll());
        System.out.println(id);
        return "gd2/product/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productRepo.deleteById(id);
        return "redirect:/gd2/product";
    }
}
