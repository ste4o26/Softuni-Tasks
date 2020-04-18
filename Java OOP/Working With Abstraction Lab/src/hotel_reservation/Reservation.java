package hotel_reservation;

public class Reservation {
    private double pricePerDay;
    private int numberOfDays;
    private String season;
    private String discountType;

    public Reservation(double pricePerDay, int numberOfDays, String season, String discountType) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discountType = discountType;
    }

    public String getDiscountType() {
        return discountType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public String getSeason() {
        return season;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}
