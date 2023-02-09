package com.shubhampandit.budgetapp.bank.service.deposit;

import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.repository.BankRepository;
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
