package com.example.myexpend.service;

import com.example.myexpend.dto.CalculateDto;
import com.example.myexpend.repository.CalculateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateService {

    @Autowired
    CalculateRepository calculateRepository;

    @Transactional
    public void addExpendBox(CalculateDto calculateDto, List<?> arr) {
        String arrSt = (String) arr.get(0);
        String[] arrStList = arrSt.split(",");

        java.sql.Date date = java.sql.Date.valueOf(arrStList[2]);
        Timestamp timestamp = new Timestamp(date.getTime());
        calculateDto.setConsumptionType(arrStList[0]);
        calculateDto.setExpendMoney(Integer.parseInt(arrStList[1]));
        calculateDto.setTodayDate(timestamp);
        calculateRepository.insertExpendList(calculateDto);
    }

    @Transactional
    public int todaySumExpend(){
        try {
            return calculateRepository.selectTodaySumExpend();
        } catch (Exception e){
            return 0;
        }
    }
}

// (()[[]])([])   22  6
//  28

// ( [ [ ] ]

//s = list(input())
//        q = []
//
//        for i in s:
//        if i == ')':
//        t = 0
//        while q:
//        top = q.pop()
//        if top == '(':
//        if t == 0:
//        q.append(2)
//        else:
//        q.append(2 * t)
//        break
//        elif top == '[':
//        print(0)
//        exit(0)
//        else:
//        t = t + int(top)
//
//        elif i == ']':
//        t = 0
//        while q:
//        top = q.pop()
//        if top == '[':
//        if t == 0:
//        q.append(3)
//        else:
//        q.append(3 * t)
//        break
//        elif top == '(':
//        print(0)
//        exit(0)
//        else:
//        t = t + int(top)
//
//        else:
//        q.append(i)
//
//        result = 0
//        for i in q:
//        if i == "(" or i == "[":
//        result = 0
//        break
//        else:
//        result += i
//
//        print(result)




