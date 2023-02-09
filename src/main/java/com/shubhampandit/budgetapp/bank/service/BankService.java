package com.shubhampandit.budgetapp.bank.service;

import com.shubhampandit.budgetapp.bank.dto.BankDto;
import com.shubhampandit.budgetapp.bank.model.Bank;

import java.util.List;

public interface BankService {
    public List<Bank> getAllBank();
    public Bank addBank(BankDto bankDto);
    public Bank updateBank();
    public void deleteBank();
}
