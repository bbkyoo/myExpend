package com.example.myexpend.service;

import com.example.myexpend.dto.CalculateDto;
import com.example.myexpend.repository.CalculateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateService {

    @Autowired
    CalculateRepository calculateRepository;

    @Transactional
    public void addExpendBox(CalculateDto calculateDto, List<?> arr) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        SimpleDateFormat formatType = new SimpleDateFormat("yyyy-MM-dd");

        String arrSt = (String) arr.get(0);
        String[] arrStList = arrSt.split(",");
        calculateDto.setConsumptionType(arrStList[0]);
        calculateDto.setExpendMoney(Integer.parseInt(arrStList[1]));
        calculateDto.setTodayDate(timestamp);
        calculateRepository.insertExpendList(calculateDto);
    }
}









