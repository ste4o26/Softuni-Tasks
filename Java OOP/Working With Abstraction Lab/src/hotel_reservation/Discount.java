package hotel_reservation;

public enum Discount {
    VIP(0.20),
    SecondVisit(0.10),
    None(0.0);

    private double discountPercentage;

    Discount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage(){
        return this.discountPercentage;
    }
}
