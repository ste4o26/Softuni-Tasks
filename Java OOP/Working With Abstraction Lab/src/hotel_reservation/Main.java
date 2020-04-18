package hotel_reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        String season = tokens[2];
        String discountType = tokens[3];

        Reservation reservation = new Reservation(pricePerDay, numberOfDays, season, discountType);
        PriceCalculator priceCalculator = new PriceCalculator(reservation);
        double totalPrice = priceCalculator.calculateReservationPrice();
        System.out.printf("%.2f", totalPrice);

    }
}
