package com.shubhampandit.budgetapp.bank.repository;

import com.shubhampandit.budgetapp.bank.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    public Bank findByName(String name);
}
