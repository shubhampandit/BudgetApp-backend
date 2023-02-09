package com.shubhampandit.budgetapp.bank.service;

import com.shubhampandit.budgetapp.bank.dto.BankDto;
import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.repository.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankServiceImplTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankServiceImpl bankService;

    @Test
    void BankServiceImpl_getAllBank_verifyBankRepositoryFindAllMethodCalled() {
        bankService.getAllBank();

        verify(bankRepository).findAll();
    }

    @Test
    void BankServiceImpl_addBank_returnsCreatedBank() {
        BankDto bankDto = BankDto.builder()
                .name("Chase")
                .type("current")
                .amount(125L)
                .interestRate(0.0)
                .build();
        Bank expectedBank = Bank.builder()
                .id(100L)
                .name("Chase")
                .type("current")
                .amount(125L)
                .interestRate(0.0)
                .build();

        when(bankRepository.save(any())).thenReturn(expectedBank);
        Bank actualBank = bankService.addBank(bankDto);

        verify(bankRepository).save(any());
        assertThat(actualBank).isEqualTo(expectedBank);
    }

    @Test
    void updateBank() {
    }

    @Test
    void deleteBank() {
    }
}