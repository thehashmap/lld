package parkingLot.entities;

import parkingLot.vehicle.Vehicle;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingFloor {
    private final int floorNumber;
    private final Map<String, ParkingSpot> spots;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.spots = new ConcurrentHashMap<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.put(spot.getId(), spot);
    }

    public synchronized Optional<ParkingSpot> findAvailableSpot(Vehicle vehicle) {
        return spots.values().stream()
                .filter(spot -> spot.isAvailable() && spot.canFitVehicle(vehicle))
                .findFirst();
    }
}
