package com.example.demo.controller.GD2;

import com.example.demo.Model.Category;
import com.example.demo.Repo.CategoryRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gd2/category")
public class CategoryController {

    private final CategoryRepository categoryRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("items", categoryRepo.findAll());
        return "gd2/category/index";
    }


    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("category") Category category,
                       Errors errors,
                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("items", categoryRepo.findAll());
            return "gd2/category/index";
        }

        categoryRepo.save(category);
        return "redirect:/gd2/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("category",
                categoryRepo.findById(id).orElse(new Category()));
        model.addAttribute("items", categoryRepo.findAll());
        return "gd2/category/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        categoryRepo.deleteById(id);
        return "redirect:/gd2/category";
    }
}
