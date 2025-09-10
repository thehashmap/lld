package carRental;

import java.util.List;

public class VehicleInventoryManagement {
    private List<Vehicle> vehicleList;

    public VehicleInventoryManagement(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }
}
