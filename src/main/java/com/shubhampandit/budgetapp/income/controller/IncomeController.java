package com.shubhampandit.budgetapp.income.controller;

import com.shubhampandit.budgetapp.income.dto.IncomeDto;
import com.shubhampandit.budgetapp.income.model.Income;
import com.shubhampandit.budgetapp.income.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping("/")
    public ResponseEntity<List<Income>> getAllIncome(){
        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    @PostMapping("/")
    public ResponseEntity<Income> addIncome(@RequestBody IncomeDto incomeDto){
        return new ResponseEntity<Income>(incomeService.addIncome(incomeDto), HttpStatus.CREATED);
    }
}
