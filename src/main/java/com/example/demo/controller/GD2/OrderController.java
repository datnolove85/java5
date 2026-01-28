package com.example.demo.controller.GD2;

import com.example.demo.Model.Order;
import com.example.demo.Repo.OrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gd2/order")
public class OrderController {

    private final OrderRepository orderRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("items", orderRepo.findAll());
        return "gd2/order/index";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("order") Order order,
                       Errors errors,
                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("items", orderRepo.findAll());
            return "gd2/order/index";
        }

        orderRepo.save(order);
        return "redirect:/gd2/order";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("order",
                orderRepo.findById(id).orElse(new Order()));
        model.addAttribute("items", orderRepo.findAll());
        return "gd2/order/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderRepo.deleteById(id);
        return "redirect:/gd2/order";
    }
}
