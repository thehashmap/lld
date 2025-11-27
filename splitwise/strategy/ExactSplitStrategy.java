package splitwise.strategy;

import splitwise.entity.Split;
import splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ExactSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> calculateSplits(Double totalAmount, User paidBy, List<User> members, List<Double> splitValues) {
        List<Split> splits = new ArrayList<>();
        if(members.size() != splitValues.size()) {
            throw new IllegalArgumentException("Size of members and splitValues can not be different!");
        }
        if(Math.abs(splitValues.stream().mapToDouble(Double::doubleValue).sum() - totalAmount) > 0.01) {
            throw new IllegalArgumentException("Total Amount and sum of exact expenses must be equal!");
        }
        for(int i = 0;i<members.size();i++) {
            splits.add(new Split(members.get(i), splitValues.get(i)));
        }
        return splits;
    }
}
