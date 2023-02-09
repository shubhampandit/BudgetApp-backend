package com.shubhampandit.BudgetApp.Bank.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
    private String name;
    private String type;
    private Long amount;
    private Double interestRate;
}
