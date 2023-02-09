package com.shubhampandit.BudgetApp.Income.Service;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import com.shubhampandit.BudgetApp.Bank.Service.Deposit.BankDepositService;
import com.shubhampandit.BudgetApp.Income.Dto.IncomeDto;
import com.shubhampandit.BudgetApp.Income.Model.Income;
import com.shubhampandit.BudgetApp.Income.Repository.IncomeRepository;
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
