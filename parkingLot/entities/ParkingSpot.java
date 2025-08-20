package parkingLot.entities;

import parkingLot.vehicle.Vehicle;
import parkingLot.vehicle.VehicleType;

public class ParkingSpot {
    private final String spotId;
    private final VehicleType spotType;
    private Vehicle currentVehicle;
    private boolean isAvailable;

    public ParkingSpot(String spotId, VehicleType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = true;
        this.currentVehicle = null;
    }

    public String getId() {
        return spotId;
    }
    public VehicleType getType() {
        return spotType;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        this.currentVehicle = vehicle;
        this.isAvailable = false;
    }

    public synchronized void unparkVehicle() {
        this.currentVehicle = null;
        this.isAvailable = true;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if(!isAvailable) return false;
        return spotType == vehicle.getType();
    }
}
