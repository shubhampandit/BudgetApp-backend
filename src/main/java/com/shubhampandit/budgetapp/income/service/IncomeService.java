package com.shubhampandit.budgetapp.income.service;

import com.shubhampandit.budgetapp.income.dto.IncomeDto;
import com.shubhampandit.budgetapp.income.model.Income;

import java.util.List;

public interface IncomeService {
    public List<Income> getAllIncome();
    public Income addIncome(IncomeDto incomeDto);
}
