package carRental;

public class Bill {
    private Reservation reservation;
    private double billAmount;
    private boolean isBillPaid;

    public Bill(Reservation reservation) {
        int rate = reservation.getVehicle().getPricePerDay();
        this.billAmount = rate;
        isBillPaid = false;
    }
}
