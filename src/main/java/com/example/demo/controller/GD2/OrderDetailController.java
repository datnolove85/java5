package com.example.demo.controller.GD2;

import com.example.demo.Model.OrderDetail;
import com.example.demo.Repo.OrderDetailRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gd2/order-detail")
public class OrderDetailController {

    private final OrderDetailRepository orderDetailRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("orderDetail", new OrderDetail());
        model.addAttribute("items", orderDetailRepo.findAll());
        return "gd2/order-detail/index";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("orderDetail") OrderDetail orderDetail,
                       Errors errors,
                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("items", orderDetailRepo.findAll());
            return "gd2/order-detail/index";
        }

        orderDetailRepo.save(orderDetail);
        return "redirect:/gd2/order-detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("orderDetail",
                orderDetailRepo.findById(id).orElse(new OrderDetail()));
        model.addAttribute("items", orderDetailRepo.findAll());
        return "gd2/order-detail/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        orderDetailRepo.deleteById(id);
        return "redirect:/gd2/order-detail";
    }
}
