package splitwise.strategy;

import splitwise.entity.Split;
import splitwise.entity.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{

    @Override
    public List<Split> calculateSplits(Double totalAmount, User paidBy, List<User> members, List<Double> splitValues) {
        List<Split> splits = new ArrayList<>();
        Double amountPerPerson = totalAmount / members.size();
        for(User member : members) {
            splits.add(new Split(member, amountPerPerson));
        }
        return splits;
    }
}
