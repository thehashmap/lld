package carRental;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final String storeId;
    private final Location location;
    private List<Reservation> reservationList = new ArrayList<>();
    private VehicleInventoryManagement vehicleInventoryManagement;

    public Store(String storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(User user, Vehicle vehicle) {
        Reservation reservation = new Reservation();
        reservation.createReservation(user,vehicle);
    }

}
