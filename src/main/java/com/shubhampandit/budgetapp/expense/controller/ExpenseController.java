package com.shubhampandit.budgetapp.expense.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ExpenseController {
    @GetMapping("/")
    public String getExpense(){
        return "Hello World";
    }

    @PostMapping("/")
    public String createExpense(){
        return "";
    }

    @PutMapping("/")
    public String updateExpense(){
        return "";
    }

    @DeleteMapping("/")
    public String deleteExpense(){
        return "";
    }
}
