package org.PROG2.budgetmaster.expense;

import lombok.Getter;
import lombok.Setter;
import org.PROG2.budgetmaster.utils.Generator;

import java.time.LocalDate;

@Getter
@Setter
public class Expense {
    private String id;
    private String description;
    private Double amount;
    private LocalDate date;
    private ExpenseCategory category;

    public Expense(String description, Double amount, ExpenseCategory category, String date) {
        this.id = Generator.id();
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = LocalDate.parse(date);

    }
}
