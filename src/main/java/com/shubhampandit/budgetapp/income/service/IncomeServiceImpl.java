package com.shubhampandit.budgetapp.income.service;

import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.service.deposit.BankDepositService;
import com.shubhampandit.budgetapp.income.dto.IncomeDto;
import com.shubhampandit.budgetapp.income.model.Income;
import com.shubhampandit.budgetapp.income.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService{

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private BankDepositService bankDepositService;

    @Override
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    @Override
    public Income addIncome(IncomeDto incomeDto) {
        Bank bank = bankDepositService.deposit(incomeDto.getBankName(), incomeDto.getAmount());
        Income income = Income.builder()
                .name(incomeDto.getName())
                .amount(incomeDto.getAmount())
                .bank(bank)
                .build();
        return incomeRepository.save(income);
    }
}
