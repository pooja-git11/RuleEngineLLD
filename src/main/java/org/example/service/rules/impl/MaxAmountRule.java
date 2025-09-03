package org.example.service.rules.impl;

import org.example.model.Expense;
import org.example.service.rules.ExpenseRule;
import org.example.service.rules.Violation;

import java.util.Optional;

public class MaxAmountRule implements ExpenseRule {
    double maxAmount;

    public MaxAmountRule(double maxAmount){
        this.maxAmount = maxAmount;
    }

    public Optional<Violation> check(Expense expense){
        if(expense.getAmount_usd() > maxAmount)
            return Optional.of(Violation.of("No "+ expense.getExpense_type() + " expense can exceed $" + maxAmount));

        return Optional.empty();
    }
}
