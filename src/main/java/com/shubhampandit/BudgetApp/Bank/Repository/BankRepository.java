package com.shubhampandit.BudgetApp.Bank.Repository;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    public Bank findByName(String name);
}
