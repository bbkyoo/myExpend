package com.example.myexpend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculateDto {
    private String consumptionType;
    private int expendMoney;
    private Timestamp todayDate;
}