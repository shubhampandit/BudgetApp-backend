package com.shubhampandit.BudgetApp.Expense.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
    private String name;
    private String type;
    private Long amount;
    private String bankName;
    private Date date;
}
