import java.util.Scanner;

public class SummerOutfit {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input
        // check if it is morning afternoon or evening
        // check degrees for the outfit

        int degrees = Integer.parseInt(sc.nextLine());
        String dayTime = sc.nextLine().toLowerCase();

        boolean isMorning = dayTime.equals("morning");
        boolean isAfternoon = dayTime.equals("afternoon");

        boolean isDegreesBetween10And18 = degrees >= 10 && degrees <= 18;
        boolean isDegreesBetween18And24 = degrees > 18 && degrees <= 24;
        boolean isDegreesMoreThan24 = degrees > 24;

        //its better practice to create two String variables for the outfit and shoes and initialize them with null so later in the program i will replace them with sweatshirt sneakers etc

        if (isMorning) {

            if (isDegreesBetween10And18) {
                System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers.", degrees);

            } else if (isDegreesBetween18And24) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);


            } else if (isDegreesMoreThan24) {
                System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees);

            }

        } else if (isAfternoon) {

            if (isDegreesBetween10And18) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);

            } else if (isDegreesBetween18And24) {
                System.out.printf("It's %d degrees, get your T-Shirt and Sandals.", degrees);


            } else if (isDegreesMoreThan24) {
                System.out.printf("It's %d degrees, get your Swim Suit and Barefoot.", degrees);

            }

        } else {

            if (isDegreesBetween10And18) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);

            } else if (isDegreesBetween18And24) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);


            } else if (isDegreesMoreThan24) {
                System.out.printf("It's %d degrees, get your Shirt and Moccasins.", degrees);

            }
        }
    }
}