package com.shubhampandit.budgetapp.income.repository;

import com.shubhampandit.budgetapp.income.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
