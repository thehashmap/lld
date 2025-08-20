package parkingLot.strategy;

import parkingLot.entities.ParkingFloor;
import parkingLot.entities.ParkingSpot;
import parkingLot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
