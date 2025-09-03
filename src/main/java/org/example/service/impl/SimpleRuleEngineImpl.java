package org.example.service.impl;

import org.example.model.Expense;
import org.example.model.ExpenseType;
import org.example.service.RuleEngine;
import org.example.service.rules.ExpenseRule;
import org.example.service.rules.Violation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SimpleRuleEngineImpl implements RuleEngine {

    public List<Violation> evaluate(
            List<Expense> expenses,
            Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry,
            List<ExpenseRule> globalExpenseRuleRegistry){

        List<Violation> violationList = new ArrayList<>();

        for(Expense expense: expenses){
            List<ExpenseRule> expenseRules = expenseRuleRegistry.getOrDefault(expense.getExpense_type(), List.of());
            checkExpenseAgainstRule(expense, expenseRules, violationList);
            checkExpenseAgainstRule(expense, globalExpenseRuleRegistry, violationList);
        }

        return violationList;
    }

    public void checkExpenseAgainstRule(Expense expenses, List<ExpenseRule> expenseRule, List<Violation> violationList){

        for(ExpenseRule rule: expenseRule){
            Optional<Violation> violation = rule.check(expenses);
//            if(violation.isPresent())
//                violationList.add(violation.get());
            violation.ifPresent(violationList::add);
        }
    }
}
