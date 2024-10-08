package org.PROG2.budgetmaster.user;

import lombok.Getter;
import lombok.Setter;
import org.PROG2.budgetmaster.expense.Expense;
import org.PROG2.budgetmaster.expense.ExpenseCategory;
import org.PROG2.budgetmaster.utils.DictElement;
import org.PROG2.budgetmaster.utils.Generator;

import java.time.LocalDate;
import java.util.ArrayList;
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
        this.expenses = new ArrayList<>();

    }

    // EXPENSE TRACKING
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

    // BUDGET ANALYSIS
    public double getMonthTotalExpenses(){
        LocalDate currentDate = LocalDate.now();
        return getMonthTotalExpenses(currentDate.getYear(), currentDate.getMonthValue());
    }

    public double getRemainingMonthBudget(){
        LocalDate currentDate = LocalDate.now();
        return getRemainingMonthBudget(currentDate.getYear(), currentDate.getMonthValue());
    }

    public double getMonthTotalExpenses(int year, int month) {
        List<Expense> expenses = getExpenses().stream().filter((e)->( e.getDate().getYear() == year && e.getDate().getMonthValue() == month)).toList();
        int total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    public double getRemainingMonthBudget(int year, int month) {
        return monthlyBudget - getMonthTotalExpenses(year, month);
    }

    public boolean isBudgetOverrun(){
        return getMonthTotalExpenses() <= monthlyBudget;
    }

    // EXPENSES SUMMARY
    public List<ExpenseCategory> getTopCategories(){
        List<ExpenseCategory> topCategories = new ArrayList<>();

        topCategories = getDictCategories().subList(0, 3).stream().map(DictElement::getKey).toList();

        return topCategories;
    }

    public List<DictElement<ExpenseCategory, Double>> calculateAverageSpendingPerCategory() {

        List<DictElement<ExpenseCategory, Double>> dictCategories = new ArrayList<>(getDictCategories());
        dictCategories.forEach(cat -> {
            cat.setValue(cat.getValue() / cat.getIntValue());
        });

        return dictCategories;
    }

    public List<DictElement<ExpenseCategory, Double>> getDictCategories(){

        List<DictElement<ExpenseCategory, Double>> dictCategories = new ArrayList<>();

        for (ExpenseCategory category : ExpenseCategory.values()) {
            dictCategories.add(new DictElement<ExpenseCategory, Double>(category, 0d));
        }

        for (Expense expense : expenses) {
            dictCategories.forEach(cat -> {
                if (expense.getCategory().equals(cat.getKey())) {
                    cat.setValue(cat.getValue() + expense.getAmount());
                    cat.setIntValue(cat.getIntValue() + 1);
                }
            });
        }

        dictCategories.sort((a, b) -> (int) (b.getValue() - a.getValue()));

        return dictCategories;
    }


}
