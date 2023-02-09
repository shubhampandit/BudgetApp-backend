package com.shubhampandit.budgetapp.bank.service.withdrawal;

import com.shubhampandit.budgetapp.bank.model.Bank;

public interface BankWithdrawalService {
    public Bank withdraw(String bankName, Long amount);
}
