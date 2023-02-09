package com.shubhampandit.BudgetApp.Bank.Service.Withdrawal;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import com.shubhampandit.BudgetApp.Bank.Repository.BankRepository;
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
class BankWithdrawalServiceImplTest {

    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankWithdrawalServiceImpl bankWithdrawalService;

    @Test
    void BankWithdrawalService_withdraw_returnsModifiedBank() {
        Bank expectedBank = Bank.builder()
                .id(100L).name("HSBC").type("current").amount(1000L).interestRate(0.0).build();

        when(bankRepository.findByName("HSBC")).thenReturn(expectedBank);
        bankWithdrawalService.withdraw("HSBC", 500L);

        ArgumentCaptor<Bank> bankArgumentCaptor = ArgumentCaptor.forClass(Bank.class);
        verify(bankRepository).save(bankArgumentCaptor.capture());
        Bank actualBank = bankArgumentCaptor.getValue();
        assertThat(actualBank).isNotNull();
        assertThat(actualBank.getAmount()).isEqualTo(500L);
    }
}