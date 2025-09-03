package org.example.model;

public class Expense {

    String expense_id;
    String trip_id;
    Double amount_usd;
    ExpenseType expense_type;
    String vendor_name;

    public Expense(String expense_id, String trip_id, Double amount_usd, ExpenseType expense_type, String vendor_name){
        this.expense_id = expense_id;
        this. trip_id = trip_id;
        this.amount_usd = amount_usd;
        this.expense_type = expense_type;
        this.vendor_name = vendor_name;
    }

    public String getExpense_id() {
        return expense_id;
    }

    public String getTrip_id() {
        return trip_id;
    }

    public Double getAmount_usd() {
        return amount_usd;
    }

    public ExpenseType getExpense_type() {
        return expense_type;
    }

    public String getVendor_name() {
        return vendor_name;
    }
}
