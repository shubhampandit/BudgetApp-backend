package com.shubhampandit.budgetapp.income.service;

import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.service.deposit.BankDepositService;
import com.shubhampandit.budgetapp.income.dto.IncomeDto;
import com.shubhampandit.budgetapp.income.model.Income;
import com.shubhampandit.budgetapp.income.repository.IncomeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IncomeServiceImplTest {

    @Mock
    private IncomeRepository incomeRepository;

    @Mock
    private BankDepositService bankDepositService;

    @InjectMocks
    private IncomeServiceImpl incomeService;

    @Test
    void IncomeService_getAllIncome_verifyMethodCalled() {
        incomeService.getAllIncome();

        verify(incomeRepository).findAll();
    }

    @Test
    void IncomeService_addIncome_returnsCreatedIncome() {
        IncomeDto incomeDto = IncomeDto.builder()
                .name("Salary").amount(1000L).bankName("Chase").build();
        Bank bank = Bank.builder()
                        .id(100L).name("Chase").type("saving").amount(1500L).interestRate(2.3).build();

        when(bankDepositService.deposit(incomeDto.getBankName(), incomeDto.getAmount())).thenReturn(bank);
        incomeService.addIncome(incomeDto);

        ArgumentCaptor<Income> incomeArgumentCaptor = ArgumentCaptor.forClass(Income.class);
        verify(incomeRepository).save(incomeArgumentCaptor.capture());
        Income createdIncome = incomeArgumentCaptor.getValue();
        assertThat(createdIncome).isNotNull();
        assertThat(createdIncome.getName()).isEqualTo("Salary");
        assertThat(createdIncome.getBank()).isEqualTo(bank);
    }
}