package parkingLot;


import parkingLot.entities.ParkingFloor;
import parkingLot.entities.ParkingSpot;
import parkingLot.entities.ParkingTicket;
import parkingLot.vehicle.*;

import java.util.Optional;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingFloor floor1 = new ParkingFloor(1);
        floor1.addSpot(new ParkingSpot("F1-S1", VehicleType.CAR));
        floor1.addSpot(new ParkingSpot("F1-S2", VehicleType.TRUCK));
        floor1.addSpot(new ParkingSpot("F1-S3", VehicleType.BIKE));

        parkingLot.addFloor(floor1);

        Vehicle bike = new Bike("B-1");
        Vehicle car = new Car("C-1");
        Vehicle truck = new Truck("T-1");

        Optional<ParkingTicket> bikeTicket = parkingLot.parkVehicle(bike);
        Optional<ParkingTicket> carTicket = parkingLot.parkVehicle(car);
        Optional<ParkingTicket> truckTicket = parkingLot.parkVehicle(truck);

        if(carTicket.isPresent()) {
            Optional<Double> fees = parkingLot.unparkVehicle(car.getLicenseNumber());
            fees.ifPresent(fee -> System.out.printf("Car fees: $%.2f\\n", fee));
        }
    }
}
