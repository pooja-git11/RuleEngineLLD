package org.example.service;

import org.example.model.Expense;
import org.example.model.ExpenseType;
import org.example.service.rules.ExpenseRule;
import org.example.service.rules.Violation;

import java.util.List;
import java.util.Map;

public interface RuleEngine {

    List<Violation> evaluate(
            List<Expense> expenses,
            Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry,
            List<ExpenseRule> globalExpenseRuleRegistry
    );
}
