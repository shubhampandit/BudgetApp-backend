package com.shubhampandit.BudgetApp.Expense.Repository;

import com.shubhampandit.BudgetApp.Expense.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
