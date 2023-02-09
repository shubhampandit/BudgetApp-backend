package com.shubhampandit.BudgetApp.Bank.Service.Deposit;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import com.shubhampandit.BudgetApp.Bank.Repository.BankRepository;
import org.springframework.stereotype.Service;

@Service
public class BankDepositServiceImpl implements BankDepositService{

    private BankRepository bankRepository;
    @Override
    public Bank deposit(String bankName, Long amount) {
        Bank bank = bankRepository.findByName(bankName);

        Long newAmount = bank.getAmount() + amount;
        bank.setAmount(newAmount);

        return bankRepository.save(bank);
    }
}
