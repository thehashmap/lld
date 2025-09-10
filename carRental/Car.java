package carRental;

import carRental.enums.VehicleStatus;
import carRental.enums.VehicleType;

public class Car extends Vehicle{
    public Car(String vehicleId, String vehicleNumber, String companyName, int kmDriven, int noOfSeats, int mileage, VehicleStatus vehicleStatus, VehicleType vehicleType) {
        super(vehicleId, vehicleNumber, companyName, kmDriven, noOfSeats, mileage, vehicleStatus, vehicleType);
    }
}
