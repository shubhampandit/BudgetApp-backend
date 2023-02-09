package com.shubhampandit.BudgetApp.Income.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncomeDto {
    private String name;
    private Long amount;
    private String bankName;
}
