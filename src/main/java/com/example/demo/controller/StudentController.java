package com.example.demo.controller;

import com.example.demo.Model.Student;
import com.example.demo.Repo.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("hien-thi-student")
    public String hienThiStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("list", studentRepository.findAll());
        return "/DataBinding/student";
    }

    @GetMapping("student/delete")
    public String deleteStudent(@RequestParam("id") int id, Model model) {
        studentRepository.deleteById(id);
        return "redirect:/hien-thi-student";
    }
    @PostMapping("student/crud")
    public String saveStudent(
            @RequestParam String name,
            Model model,
            @ModelAttribute("student") @Valid Student student,
            Errors errors) {
        if (name.equals("add")) {
            if (errors.hasErrors()) {
                model.addAttribute("list", studentRepository.findAll());
                model.addAttribute("message", "Lỗi,nhập lại!");
                return "/DataBinding/student";
            }
            student.setId(null);
            studentRepository.save(student);
        } else if (name.equals("update")) {
            if (errors.hasErrors()) {
                model.addAttribute("list", studentRepository.findAll());
                model.addAttribute("message", "Lỗi,nhập lại!");
                return "/DataBinding/student";
            }
            studentRepository.save(student);
        } else if (name.equals("delete")) {
            studentRepository.deleteById(student.getId());
        }

        return "redirect:/hien-thi-student";
    }
}

