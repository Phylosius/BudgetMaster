package org.PROG2.budgetmaster.user;

import lombok.Getter;
import lombok.Setter;
import org.PROG2.budgetmaster.expense.Expense;
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
}
