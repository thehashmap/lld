package parkingLot.strategy;

import parkingLot.entities.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy{
    private static final double RATE_PER_HOUR = 10.0;
    @Override
    public double calculateFee(ParkingTicket ticket) {
        long duration = ticket.getExitTime() - ticket.getIssueTime();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * RATE_PER_HOUR;
    }
}
