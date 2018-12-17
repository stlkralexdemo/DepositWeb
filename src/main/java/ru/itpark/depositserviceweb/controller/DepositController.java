package ru.itpark.depositserviceweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.depositserviceweb.service.DepositService;

@Controller
public class DepositController {
    private final DepositService service;

    public DepositController(DepositService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("welcome", "Hello");
        return "index";
    }

    @PostMapping
    public String index(Model model, @RequestParam int deposit,@RequestParam int percent,@RequestParam int date) {
        model.addAttribute("welcome", "Hello");
        model.addAttribute("summa", service.calculateDeposit(deposit, percent, date));
        return "index";
    }
}

