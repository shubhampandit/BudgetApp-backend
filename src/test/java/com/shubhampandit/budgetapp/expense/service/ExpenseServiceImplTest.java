package com.shubhampandit.budgetapp.expense.service;

import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.service.withdrawal.BankWithdrawalService;
import com.shubhampandit.budgetapp.expense.dto.ExpenseDto;
import com.shubhampandit.budgetapp.expense.model.Expense;
import com.shubhampandit.budgetapp.expense.repository.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceImplTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private BankWithdrawalService bankWithdrawalService;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    @Test
    void ExpenseService_getAllExpense_verifyFindAllMethodCalled() {
        expenseService.getAllExpense();

        verify(expenseRepository).findAll();
    }

    @Test
    void ExpenseService_addExpense_verifyIncome() {
        ExpenseDto expenseDto = ExpenseDto.builder()
                .name("Food").type("variable").amount(100L).bankName("HSBC").date(Calendar.getInstance().getTime()).build();
        Bank bank = Bank.builder()
                .id(100L).name("HSBC").type("current").amount(1500L).interestRate(0.0).build();

        when(bankWithdrawalService.withdraw("HSBC", 100L)).thenReturn(bank);
        expenseService.addExpense(expenseDto);

        ArgumentCaptor<Expense> expenseArgumentCaptor = ArgumentCaptor.forClass(Expense.class);
        verify(expenseRepository).save(expenseArgumentCaptor.capture());
        Expense expense = expenseArgumentCaptor.getValue();
        assertThat(expense).isNotNull();
        assertThat(expense.getName()).isEqualTo("Food");
        assertThat(expense.getBank()).isEqualTo(bank);
    }
}