package com.example.myexpend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculateDto {
    private String  consumptionType;
    private int expendMoney;
}
