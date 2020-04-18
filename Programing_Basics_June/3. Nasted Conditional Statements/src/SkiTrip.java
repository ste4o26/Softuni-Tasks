import java.util.Scanner;

public class SkiTrip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int stay = Integer.parseInt(sc.nextLine());
        String roomType = sc.nextLine();
        String evaluation = sc.nextLine();

        int onePersonRoomPrice = 18;
        int apartmentPrice = 25;
        int presidentApartmentPrice = 35;

        boolean isPositive = evaluation.equals("positive");

        boolean isOnePersonRoom = roomType.equals("room for one person");
        boolean isApartment = roomType.equals("apartment");
        boolean isPresidentApartment = roomType.equals("president apartment");

        boolean isLessThan10Days = stay < 10;
        boolean isBetween10And15Days = stay >= 10 && stay <= 15;
        boolean isMoreThan15Days = stay > 15;

        double totalPrice = 0;

        if (isOnePersonRoom) {
            totalPrice = (stay-1) * onePersonRoomPrice;
           // System.out.printf("%.2f", totalPrice);

        } else if (isApartment) {
            totalPrice = (stay-1) * apartmentPrice;

            if (isLessThan10Days) {
                totalPrice = totalPrice * 0.7;
             //   System.out.printf("%.2f", totalPrice);

            } else if (isBetween10And15Days) {
                totalPrice = totalPrice * 0.65;
               // System.out.printf("%.2f", totalPrice);

            } else {
                totalPrice = totalPrice * 0.5;
               // System.out.printf("%.2f", totalPrice);

            }

        } else if (isPresidentApartment) {
            totalPrice = (stay-1) * presidentApartmentPrice;

            if (isLessThan10Days) {
                totalPrice = totalPrice * 0.9;
               // System.out.printf("%.2f", totalPrice);

            } else if (isBetween10And15Days) {
                totalPrice = totalPrice * 0.85;
             //   System.out.printf("%.2f", totalPrice);

            } else {
                totalPrice = totalPrice * 0.80;
                //System.out.printf("%.2f", totalPrice);

            }
        }

        if(isPositive){
            totalPrice = totalPrice + totalPrice * 0.25;
            System.out.printf("%.2f", totalPrice);

        }else {
            totalPrice = totalPrice - totalPrice * 0.1;
            System.out.printf("%.2f", totalPrice);

        }
    }
}
