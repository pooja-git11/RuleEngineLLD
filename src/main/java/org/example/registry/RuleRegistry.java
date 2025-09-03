package org.example.registry;

import org.example.model.ExpenseType;
import org.example.service.rules.ExpenseRule;
import org.example.service.rules.impl.DisallowRule;
import org.example.service.rules.impl.MaxAmountRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuleRegistry {

    public static Map<ExpenseType, List<ExpenseRule>> getExpenseRuleRegistry(){
        Map<ExpenseType, List<ExpenseRule>> registry = new HashMap<>();

        registry.put(ExpenseType.AIRFATE, List.of(
                new DisallowRule()
        ));

        registry.put(ExpenseType.RESTAURANT, List.of(
                new MaxAmountRule(75)
        ));
        return registry;
    }

    public static List<ExpenseRule> getGlobalExpenseRuleRegistry(){
        return List.of(
                new MaxAmountRule(250)
        );
    }


}
