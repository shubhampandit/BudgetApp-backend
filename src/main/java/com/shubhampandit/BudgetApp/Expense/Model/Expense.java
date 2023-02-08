package com.shubhampandit.BudgetApp.Expense.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String expenseName;
    public String expenseType; //Need to be converted to enum later.
    public Long amount;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public Date date;
}
