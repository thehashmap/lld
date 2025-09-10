package carRental;

import carRental.enums.ReservationStatus;
import carRental.enums.ReservationType;

import java.util.Date;

public class Reservation {
    private final String reservationId;
    private final User user;
    private final Vehicle vehicle;
    private final Date bookingDate;
    private final Date bookingFrom;
    private final Date bookingTill;
    private final Location location;
    private final ReservationStatus reservationStatus;
    private final ReservationType reservationType;

    public Reservation(String reservationId, User user, Vehicle vehicle, Date bookingDate, Date bookingFrom, Date bookingTill, Location location, ReservationStatus reservationStatus, ReservationType reservationType) {
        this.reservationId = reservationId;
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = bookingDate;
        this.bookingFrom = bookingFrom;
        this.bookingTill = bookingTill;
        this.location = location;
        this.reservationStatus = reservationStatus;
        this.reservationType = reservationType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
