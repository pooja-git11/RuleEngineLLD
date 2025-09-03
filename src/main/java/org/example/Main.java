package org.example;

import org.example.model.Expense;
import org.example.model.ExpenseType;
import org.example.registry.RuleRegistry;
import org.example.service.impl.SimpleRuleEngineImpl;
import org.example.service.rules.ExpenseRule;
import org.example.service.rules.Violation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Expense> expenses = new ArrayList<>();
        SimpleRuleEngineImpl simpleRuleEngine = new SimpleRuleEngineImpl();
        Map<ExpenseType, List<ExpenseRule>> expenseRuleRegistry = RuleRegistry.getExpenseRuleRegistry();
        List<ExpenseRule> globalExpenseRuleRegistry = RuleRegistry.getGlobalExpenseRuleRegistry();

        expenses.add(new Expense("001", "trip1", 80.0, ExpenseType.RESTAURANT, "Outback Roadhouse"));

        List<Violation> violationList = simpleRuleEngine.evaluate(expenses, expenseRuleRegistry, globalExpenseRuleRegistry);

        System.out.println("Expense Violations: ");
        for(Violation violation: violationList){
            System.out.println(violation.getMessage());
        }
    }
}