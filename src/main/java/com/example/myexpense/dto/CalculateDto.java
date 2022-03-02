package com.example.myexpense.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalculateDto {
    private String  consumptionType;
    private int expendMoney;
}
