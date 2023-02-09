package com.shubhampandit.BudgetApp.Income.Service;

import com.shubhampandit.BudgetApp.Income.Dto.IncomeDto;
import com.shubhampandit.BudgetApp.Income.Model.Income;

import java.util.List;

public interface IncomeService {
    public List<Income> getAllIncome();
    public Income addIncome(IncomeDto incomeDto);
}
