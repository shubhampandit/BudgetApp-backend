package com.shubhampandit.BudgetApp.Bank.Service.Deposit;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;

public interface BankDepositService {
    public Bank deposit(String bankName, Long amount);
}
