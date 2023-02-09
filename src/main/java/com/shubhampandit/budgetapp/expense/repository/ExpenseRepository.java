package com.shubhampandit.budgetapp.expense.repository;

import com.shubhampandit.budgetapp.expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
