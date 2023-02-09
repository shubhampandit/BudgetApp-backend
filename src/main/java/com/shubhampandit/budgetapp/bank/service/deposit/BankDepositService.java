package com.shubhampandit.budgetapp.bank.service.deposit;

import com.shubhampandit.budgetapp.bank.model.Bank;

public interface BankDepositService {
    public Bank deposit(String bankName, Long amount);
}
