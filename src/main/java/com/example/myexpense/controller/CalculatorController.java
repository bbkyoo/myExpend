package com.example.myexpense.controller;

import com.example.myexpense.dto.CalculateDto;
import com.example.myexpense.repository.CalculateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CalculatorController {
    @Autowired
    private CalculateRepository calculateRepository;

    @GetMapping("/calculator")
    public String openCalculator(Model model){
        return "calculator";
    }

    @PostMapping("/calculator/sendMoney")
    public void sendMoney(Model model, CalculateDto calculateDto){
        // 정상적으로 저장되었다는 시그널을 보내고 창을 닫는다.

//        model.addAttribute(,calculateRepository.getExpendList());

    }
}