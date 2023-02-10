package com.shubhampandit.budgetapp.expense.controller;

import com.shubhampandit.budgetapp.expense.dto.ExpenseDto;
import com.shubhampandit.budgetapp.expense.model.Expense;
import com.shubhampandit.budgetapp.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public ResponseEntity<List<Expense>> getAllExpense(){
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    @PostMapping("/")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseDto expenseDto){
        return new ResponseEntity<>(expenseService.addExpense(expenseDto), HttpStatus.CREATED);
    }
}
