package parkingLot.entities;

import parkingLot.vehicle.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final long issueTime;
    private long exitTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.issueTime = new Date().getTime();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getIssueTime() {
        return issueTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }


    public String generateTicket() {
        return "Ticket ID: " + ticketId + "\n" +
               "Vehicle: " + vehicle.getLicenseNumber() + "\n" +
               "Parking Spot ID: " + parkingSpot.getId() + "\n" +
               "Issue Time: " + issueTime + "\n" +
               "Exit Time: " + exitTime;
    }

}
