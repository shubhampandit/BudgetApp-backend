package com.shubhampandit.BudgetApp.Income.Model;

import com.shubhampandit.BudgetApp.Bank.Model.Bank;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "bank_id")
    private Bank bank;
}
