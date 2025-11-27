package splitwise.entity;

import java.time.Instant;
import java.util.UUID;

public class Expense {
    private final String expenseId;
    private Double amount;
    private Group group;
    private User paidBy;
    private String description;
    private Instant createdAt;

    public Expense(Double amount, Group group, User paidBy, String description) {
        this.expenseId = UUID.randomUUID().toString();
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.group = group;
        this.createdAt = Instant.now();
    }

    public String getExpenseId() {
        return expenseId;
    }

    public Double getAmount() {
        return amount;
    }

    public Group getGroup() {
        return group;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
