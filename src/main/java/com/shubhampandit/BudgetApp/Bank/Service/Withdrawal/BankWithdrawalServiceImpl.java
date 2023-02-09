package com.shubhampandit.BudgetApp.Bank.Service.Withdrawal;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import com.shubhampandit.BudgetApp.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankWithdrawalServiceImpl implements BankWithdrawalService{

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank withdraw(String bankName, Long amount) {
        Bank bank = bankRepository.findByName(bankName);

        Long newAmount = bank.getAmount() - amount;
        bank.setAmount(newAmount);

        return bankRepository.save(bank);
    }
}
