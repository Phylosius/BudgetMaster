package org.PROG2;

import org.PROG2.budgetmaster.expense.ExpenseCategory;
import org.PROG2.budgetmaster.user.User;

public class Main {
    public static void main(String[] args) {
        User john = new User("John Doe", 5000);
        john.addExpense("Bouf", 20, ExpenseCategory.FOOD, "2024-08-01");
        john.addExpense("Bouf", 20, ExpenseCategory.ENTERTAINMENT, "2024-08-01");
        john.addExpense("FF", 20, ExpenseCategory.OTHERS, "2024-08-01");
        john.addExpense("FF", 100, ExpenseCategory.OTHERS, "2024-08-01");

        System.out.println(john.getTopCategories());
        john.calculateAverageSpendingPerCategory().forEach(System.out::println);

    }
}