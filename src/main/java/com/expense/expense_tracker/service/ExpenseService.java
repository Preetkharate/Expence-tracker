package com.expense.expense_tracker.service;

import com.expense.expense_tracker.model.Expense;
import com.expense.expense_tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
    this.repository = repository;
}

    // GET ALL
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    // ADD
    public Expense addExpense(Expense expense) {
        return repository.save(expense);
    }

    // GET BY ID
    public Expense getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    // DELETE
    public void deleteExpense(int id) {
        repository.deleteById(id);
    }

    // UPDATE
    public Expense updateExpense(int id, Expense newExpense) {
        Expense existing = getById(id);
        existing.setTitle(newExpense.getTitle());
        existing.setAmount(newExpense.getAmount());
        existing.setCategory(newExpense.getCategory());
        return repository.save(existing);
    }

    // TOTAL
    public double getTotalExpense() {
        return repository.findAll()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }

    // FILTER BY CATEGORY
    public List<Expense> getByCategory(String category) {
    return repository.findByCategoryIgnoreCase(category);
}
}