package com.example.demo.controller;

import com.example.demo.Model.SinhVien;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DataBindingController {
    @GetMapping("sinh-vien")
    public String sinhVien(Model model) {
        model.addAttribute("sinhVien", new SinhVien());
        return "/DataBinding/databinding.html";
    }

    @PostMapping("/sinh-vien/save")
    public String sinhVien(Model model,
                           @ModelAttribute @Valid SinhVien sinhVien, Errors errors
                           ) {

        if(errors.hasErrors()) {
            model.addAttribute("message","Vui lòng sua lai");
        }else {
            model.addAttribute("message","Dữ liệu nhập đúng");
        }
        return "/DataBinding/databinding.html";
    }
}
