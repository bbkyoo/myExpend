package com.example.myexpend.controller;

import com.example.myexpend.dto.CalculateDto;
import com.example.myexpend.repository.CalculateRepository;
import com.example.myexpend.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CalculatorController {
    @Autowired
    private CalculateService calculateService;

    @GetMapping("/calculator")
    public String openCalculator(Model model){
        return "calculator";
    }

    @ResponseBody
    @PostMapping("/calculator/sendmoney")
    public void sendMoney(Model model, CalculateDto calculateDto, HttpServletRequest httpServletRequest){
        List<?> arr = Collections.singletonList(httpServletRequest.getParameter("arr"));
        calculateService.addExpendBox(calculateDto, arr);
    }
}