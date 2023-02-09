package com.shubhampandit.budgetapp.bank.service.withdrawal;

import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.repository.BankRepository;
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
