package org.example.service.rules;

import org.example.model.Expense;

import java.util.Optional;

public interface ExpenseRule {

    Optional<Violation> check(Expense expense);

}
