package com.shubhampandit.BudgetApp.Expense.Service;

import com.shubhampandit.BudgetApp.Expense.Dto.ExpenseDto;
import com.shubhampandit.BudgetApp.Expense.Model.Expense;

import java.util.List;

public interface ExpenseService {
    public List<Expense> getAllExpense();
    public Expense addExpense(ExpenseDto expenseDto);
}
