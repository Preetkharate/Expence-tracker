package com.expense.expense_tracker.controller;

import org.springframework.web.bind.annotation.*;

import com.expense.expense_tracker.model.Expense;
import com.expense.expense_tracker.service.ExpenseService;

import java.util.List;
//controller class to handle HTTP requests related to expenses
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    // GET all
    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }

    // POST add
    @PostMapping
    public Expense add(@RequestBody Expense expense) {
        return service.addExpense(expense);
    }

    // GET by id
    @GetMapping("/{id}")
    public Expense getById(@PathVariable int id) {
        return service.getById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
    service.deleteExpense(id);
    return "Deleted successfully";
}

    @PutMapping("/{id}")
    public Expense update(@PathVariable int id, @RequestBody Expense expense) {
    return service.updateExpense(id, expense);
    }

    @GetMapping("/total")
    public double total() {
    return service.getTotalExpense();
    }

    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {
    return service.getByCategory(category);
    }


}