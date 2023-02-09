package com.shubhampandit.BudgetApp.Bank.Service.Withdrawal;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;

public interface BankWithdrawalService {
    public Bank withdraw(String bankName, Long amount);
}
