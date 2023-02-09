package com.shubhampandit.budgetapp.expense.service;

import com.shubhampandit.budgetapp.expense.dto.ExpenseDto;
import com.shubhampandit.budgetapp.expense.model.Expense;

import java.util.List;

public interface ExpenseService {
    public List<Expense> getAllExpense();
    public Expense addExpense(ExpenseDto expenseDto);
}
