package com.shubhampandit.BudgetApp.Bank.Service;

import com.shubhampandit.BudgetApp.Bank.Dto.BankDto;
import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import com.shubhampandit.BudgetApp.Bank.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepository bankRepository;
    @Override
    public List<Bank> getAllBank() {
        return bankRepository.findAll();
    }

    @Override
    public Bank addBank(BankDto bankDto) {
        Bank bank = Bank.builder()
                .name(bankDto.getName())
                .type(bankDto.getType())
                .amount(bankDto.getAmount())
                .interestRate(bankDto.getInterestRate())
                .build();
        return bankRepository.save(bank);
    }

    @Override
    public Bank updateBank() {
        return null;
    }

    @Override
    public void deleteBank() {

    }
}
