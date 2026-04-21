package com.expense.expense_tracker.repository;

import com.expense.expense_tracker.model.Expense;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findByCategoryIgnoreCase(String category);
}