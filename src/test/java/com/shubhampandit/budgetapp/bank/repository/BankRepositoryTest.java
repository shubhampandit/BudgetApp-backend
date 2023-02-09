package com.shubhampandit.budgetapp.bank.repository;

import com.shubhampandit.budgetapp.bank.model.Bank;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class BankRepositoryTest {

    @Autowired
    private BankRepository bankRepository;

    @Test
    void BankRepository_findByName_returnsBank() {
        String bankName = "HSBC";
        Bank expectedBank = Bank.builder()
                .name(bankName)
                .type("current")
                .amount(10000L)
                .interestRate(2.9)
                .build();
        bankRepository.save(expectedBank);

        Bank actualBank = bankRepository.findByName(bankName);

        assertThat(expectedBank).isEqualTo(actualBank);
        assertThat(expectedBank.getName()).isEqualTo(bankName);
    }
}