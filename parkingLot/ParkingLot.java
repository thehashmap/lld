package parkingLot;

import parkingLot.entities.ParkingFloor;
import parkingLot.entities.ParkingSpot;
import parkingLot.entities.ParkingTicket;
import parkingLot.strategy.FeeStrategy;
import parkingLot.strategy.FlatRateFeeStrategy;
import parkingLot.strategy.NearestStrategy;
import parkingLot.strategy.ParkingStrategy;
import parkingLot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors = new ArrayList<>();
    private Map<String, ParkingTicket> activeTickets;
    private FeeStrategy feeStrategy;
    private ParkingStrategy parkingStrategy;

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public ParkingLot() {
        this.feeStrategy = new FlatRateFeeStrategy();
        this.parkingStrategy = new NearestStrategy();
        this.activeTickets = new ConcurrentHashMap<>();
    }

    public synchronized Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors, vehicle);
        if(availableSpot.isPresent()) {
            ParkingSpot spot = availableSpot.get();
            spot.parkVehicle(vehicle);
            ParkingTicket ticket = new ParkingTicket(vehicle, spot);
            activeTickets.put(vehicle.getLicenseNumber(), ticket);
            System.out.printf("%s parked at %s. Ticket: %s\n", vehicle.getLicenseNumber(), spot.getId(), ticket.getTicketId());
            return Optional.of(ticket);
        }
        System.out.println("No available spot for " + vehicle.getLicenseNumber());
        return Optional.empty();
    }

    public Optional<Double> unparkVehicle(String licenseNumber) {
        ParkingTicket ticket = activeTickets.remove(licenseNumber);
        if(ticket == null) {
            System.out.println("Ticket not found");
            return Optional.empty();
        }
        ticket.setExitTime();
        ticket.getParkingSpot().unparkVehicle();
        activeTickets.remove(ticket.getTicketId());
        double fees = feeStrategy.calculateFee(ticket);
        System.out.println("Fees for vehicle (" + licenseNumber + ") : " + fees);
        return Optional.of(fees);
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

}
