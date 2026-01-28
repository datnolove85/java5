package com.example.demo.controller.GD2;

import com.example.demo.Model.Account;
import com.example.demo.Repo.AccountRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gd2/account")
public class AccountController {

    private final AccountRepository accountRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("items", accountRepo.findAll());
        return "gd2/account/index";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("account") Account account,
                       Errors errors,
                       Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("items", accountRepo.findAll());
            return "gd2/account/index";
        }
        accountRepo.save(account);
        return "redirect:/gd2/account";
    }

    @GetMapping("/edit/{username}")
    public String edit(@PathVariable String username, Model model) {
        model.addAttribute("account",
                accountRepo.findById(username).orElse(new Account()));
        model.addAttribute("items", accountRepo.findAll());
        return "gd2/account/index";
    }

    @GetMapping("/delete/{username}")
    public String delete(@PathVariable String username) {
        accountRepo.deleteById(username);
        return "redirect:/gd2/account";
    }
}
