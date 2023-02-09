package com.shubhampandit.budgetapp.bank.controller;

import com.shubhampandit.budgetapp.bank.dto.BankDto;
import com.shubhampandit.budgetapp.bank.model.Bank;
import com.shubhampandit.budgetapp.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/")
    public ResponseEntity<List<Bank>> getAllBank(){
        return ResponseEntity.ok(bankService.getAllBank());
    }

    @PostMapping("/")
    public ResponseEntity<Bank> addBank(@RequestBody BankDto bankDto){
        return new ResponseEntity<Bank>(bankService.addBank(bankDto), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public String updateBank(){
        return "";
    }

    @DeleteMapping("/")
    public String deleteBank(){
        return "";
    }
}
