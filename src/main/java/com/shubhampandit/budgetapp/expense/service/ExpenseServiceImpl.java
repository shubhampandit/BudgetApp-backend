package com.shubhampandit.budgetapp.expense.service;

import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.service.withdrawal.BankWithdrawalService;
import com.shubhampandit.budgetapp.expense.dto.ExpenseDto;
import com.shubhampandit.budgetapp.expense.model.Expense;
import com.shubhampandit.budgetapp.expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private BankWithdrawalService bankWithdrawalService;
    @Override
    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense addExpense(ExpenseDto expenseDto) {
        Bank bank = bankWithdrawalService.withdraw(expenseDto.getBankName(), expenseDto.getAmount());
        Expense expense = Expense.builder()
                .name(expenseDto.getName())
                .type(expenseDto.getType())
                .amount(expenseDto.getAmount())
                .bank(bank)
                .date(Calendar.getInstance().getTime())
                .build();
        return expenseRepository.save(expense);
    }
}
