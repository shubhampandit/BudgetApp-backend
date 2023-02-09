package com.shubhampandit.BudgetApp.Expense.Service;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import com.shubhampandit.BudgetApp.Bank.Service.Withdrawal.BankWithdrawalService;
import com.shubhampandit.BudgetApp.Expense.Dto.ExpenseDto;
import com.shubhampandit.BudgetApp.Expense.Model.Expense;
import com.shubhampandit.BudgetApp.Expense.Repository.ExpenseRepository;
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
