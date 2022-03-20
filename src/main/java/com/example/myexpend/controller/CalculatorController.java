package com.example.myexpend.controller;

import com.example.myexpend.dto.CalculateDto;
import com.example.myexpend.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CalculatorController {
    @Autowired
    private CalculateService calculateService;

    private int today_expend_money = 0;

    @GetMapping("/calculator")
    public String openCalculator(Model model){
        return "calculator";
    }

    @ResponseBody
    @PostMapping("/calculator/sendmoney")
    public void sendMoney(Model model, CalculateDto calculateDto, HttpServletRequest httpServletRequest) {
        List<?> arr = Collections.singletonList(httpServletRequest.getParameter("arr"));
        calculateService.addExpendBox(calculateDto, arr);

//        String arrSt = (String) arr.get(0);
//        String[] arrStList = arrSt.split(",");
//        java.sql.Date date = java.sql.Date.valueOf(arrStList[2]);
//
//        Date now = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String nowDate_now = simpleDateFormat.format(now);
//        String nowDate_arr = simpleDateFormat.format(date);
//
//        if (nowDate_now.equals(nowDate_arr)){
//            today_expend_money += Integer.parseInt(arrStList[1]);
//        } else{
//            today_expend_money = 0;
//        }
    }
}