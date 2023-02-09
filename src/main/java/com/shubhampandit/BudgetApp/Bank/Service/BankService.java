package com.shubhampandit.BudgetApp.Bank.Service;

import com.shubhampandit.BudgetApp.Bank.Dto.BankDto;
import com.shubhampandit.BudgetApp.Bank.Model.Bank;

import java.util.List;

public interface BankService {
    public List<Bank> getAllBank();
    public Bank addBank(BankDto bankDto);
    public Bank updateBank();
    public void deleteBank();
}
