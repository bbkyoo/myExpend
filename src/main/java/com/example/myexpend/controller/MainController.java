package com.example.myexpend.controller;

import com.example.myexpend.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    @Autowired
    private CalculateService calculateService;

    @GetMapping("/")
    public String openMainPage(Model model){
        model.addAttribute("todaySumExpend", calculateService.todaySumExpend()+" 원");
        return "main";
    }
}
