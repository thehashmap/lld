package splitwise.entity;

import splitwise.strategy.SplitStrategy;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Expense {
    private final String expenseId;
    private Double amount;
    private List<Split> splits;
    private User paidBy;
    private String description;
    private Instant createdAt;

    private Expense(ExpenseBuilder builder) {
        this.expenseId = builder.id;
        this.amount = builder.amount;
        this.description = builder.description;
        this.paidBy = builder.paidBy;
        this.createdAt = Instant.now();
        this.splits = builder.strategy.calculateSplits(builder.amount, builder.paidBy, builder.users,
                builder.splitValues);
    }

    public String getExpenseId() {
        return expenseId;
    }

    public Double getAmount() {
        return amount;
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

    public static class ExpenseBuilder {
        private String id;
        private Double amount;
        private String description;
        private User paidBy;
        private SplitStrategy strategy;
        private List<User> users;
        private List<Double> splitValues;

        public ExpenseBuilder setId() {
            this.id = UUID.randomUUID().toString();
            return this;
        }

        public ExpenseBuilder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public ExpenseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ExpenseBuilder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public ExpenseBuilder setStrategy(SplitStrategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public ExpenseBuilder setUsers(List<User> users) {
            this.users = users;
            return this;
        }

        public ExpenseBuilder setSplitValues(List<Double> splitValues) {
            this.splitValues = splitValues;
            return this;
        }

        public Expense build() {
            if(strategy == null) {
                throw new IllegalStateException("Split strategy is required!");
            }
            return new Expense(this);
        }
    }
}
