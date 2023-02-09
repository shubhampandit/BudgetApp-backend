package com.shubhampandit.BudgetApp.Expense.Model;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import jakarta.persistence.*;
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
    private Long id;
    private String name;
    private String type; //Need to be converted to enum later.
    private Long amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "bank_id")
    private Bank bank;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
}
