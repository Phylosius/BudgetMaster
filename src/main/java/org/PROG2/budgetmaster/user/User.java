package org.PROG2.budgetmaster.user;

import lombok.Getter;
import lombok.Setter;
import org.PROG2.budgetmaster.expense.Expense;
import org.PROG2.budgetmaster.expense.ExpenseCategory;
import org.PROG2.budgetmaster.utils.Generator;

import java.util.List;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private double monthlyBudget;
    private List<Expense> expenses;

    public User(String name, double monthlyBudget) {
        this.id = Generator.id();
        this.name = name;
        this.monthlyBudget = monthlyBudget;

    }

    public void addExpense(String description, double amount, ExpenseCategory category, String date) {
        expenses.add(new Expense(description, amount, category, date));
    }

    public List<Expense> getExpensesDateSorted() {
        // return expenses sort by date
        expenses.sort((exp1, exp2) -> exp2.getDate().compareTo(exp1.getDate()));
        return expenses;
    }

    public List<Expense> getExpensesCategorySorted() {
        expenses.sort((exp1, exp2) -> exp2.getCategory().compareTo(exp1.getCategory()));
        return expenses;
    }
}
