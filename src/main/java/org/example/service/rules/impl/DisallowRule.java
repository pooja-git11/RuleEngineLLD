package org.example.service.rules.impl;

import org.example.model.Expense;
import org.example.service.rules.ExpenseRule;
import org.example.service.rules.Violation;

import java.util.Optional;

public class DisallowRule implements ExpenseRule {

    public Optional<Violation> check(Expense expense){
        return Optional.of(Violation.of("No " +  expense.getExpense_type() + " expenses are allowed"));
    }
}
