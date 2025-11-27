package splitwise.entity;

import java.util.Map;

public class Balancesheet {
    private double balance;
    private Map<User, Map<User, Double>> balances;

    public double getBalance() {
        return balance;
    }

    public Map<User, Map<User, Double>> getBalances() {
        return balances;
    }
}
