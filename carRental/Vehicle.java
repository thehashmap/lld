package carRental;

import carRental.enums.VehicleStatus;
import carRental.enums.VehicleType;

public class Vehicle {
    private String vehicleId;
    private String vehicleNumber;
    private String companyName;
    private int kmDriven;
    private int noOfSeats;
    private int mileage;
    private VehicleStatus vehicleStatus;
    private VehicleType vehicleType;
    private int pricePerDay;

    public Vehicle(String vehicleId, String vehicleNumber, String companyName, int kmDriven, int noOfSeats, int mileage, VehicleStatus vehicleStatus, VehicleType vehicleType, int pricePerDay) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.companyName = companyName;
        this.kmDriven = kmDriven;
        this.noOfSeats = noOfSeats;
        this.mileage = mileage;
        this.vehicleStatus = vehicleStatus;
        this.vehicleType = vehicleType;
        this.pricePerDay = pricePerDay;
    }

    public int getPricePerDay() { return pricePerDay; }
}
