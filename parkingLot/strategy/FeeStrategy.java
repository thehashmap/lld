package parkingLot.strategy;

import parkingLot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket ticket);
}
