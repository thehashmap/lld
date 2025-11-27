package splitwise.strategy;

import splitwise.entity.Split;
import splitwise.entity.User;

import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSplits(Double totalAmount, User paidBy, List<User> members, List<Double> splitValues);
}
