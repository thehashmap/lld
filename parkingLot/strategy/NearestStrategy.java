package parkingLot.strategy;

import parkingLot.entities.ParkingFloor;
import parkingLot.entities.ParkingSpot;
import parkingLot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class NearestStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle) {
        for(ParkingFloor floor : floors) {
            Optional<ParkingSpot> spot = floor.findAvailableSpot(vehicle);
            if(spot.isPresent()) return spot;
        }
        return Optional.empty();
    }
}
