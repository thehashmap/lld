package splitwise.entity;

public class Split {
    private User user;
    private double amount;

    public Split(User member, Double amountPerPerson) {
        this.user = member;
        this.amount = amountPerPerson;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }
}
