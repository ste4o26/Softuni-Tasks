package hotel_reservation;

public class PriceCalculator {

    private Reservation reservation;

    public PriceCalculator(Reservation reservation) {
        this.reservation = reservation;
    }

    public double calculateReservationPrice(){
        double pricePerDay = this.reservation.getPricePerDay();
        int numberOfDays = this.reservation.getNumberOfDays();

        String season = this.reservation.getSeason();
        int seasonMultiplier = Season.valueOf(season).getSeasonMultiplier();

        String discountType = this.reservation.getDiscountType();
        double discount = Discount.valueOf(discountType).getDiscountPercentage();

        return numberOfDays * (pricePerDay * seasonMultiplier) * (1 - discount);
    }
}
