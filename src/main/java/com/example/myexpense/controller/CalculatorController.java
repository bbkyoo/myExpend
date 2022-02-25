package com.example.myexpense.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CalculatorController {

    @GetMapping("/calculator")
    public String openCalculator(Model model){
        return "calculator";
    }
}
