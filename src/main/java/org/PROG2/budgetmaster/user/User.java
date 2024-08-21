package org.PROG2.budgetmaster.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private double monthlyBudget;
//    private List<Expenditure> expenditures;

    public User(String name, double monthlyBudget) {
        this.name = name;
        this.monthlyBudget = monthlyBudget;

    }
}
