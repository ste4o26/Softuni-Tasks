import java.util.Scanner;

public class Traveling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String destination = sc.nextLine();
        double priceOfVacation = 0;

        while (!(destination.equals("End"))){

            priceOfVacation = Double.parseDouble(sc.nextLine());
            double currenTmoneySaved;
            double moneySaved = 0;

            while(moneySaved < priceOfVacation) {
                currenTmoneySaved = Double.parseDouble(sc.nextLine());
                moneySaved += currenTmoneySaved;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = sc.nextLine();
        }
    }
}
