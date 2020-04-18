import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String projectionType = sc.nextLine().toLowerCase();
        int hallRows = Integer.parseInt(sc.nextLine());
        int hallCollmns = Integer.parseInt(sc.nextLine());

        int totalSeetsInHall = hallCollmns * hallRows;

        double premiereTicketPrice = 12;
        double normalTicketPrice = 7.50;
        double discountTicketPrice = 5;

        boolean isPremiere = projectionType.equals("premiere");
        boolean isNormal = projectionType.equals("normal");

        if (isPremiere){
            double totalMoneyEarned = totalSeetsInHall * premiereTicketPrice;
            System.out.printf("%.2f leva", totalMoneyEarned);

        }else if(isNormal){
            double totalMoneyEarned = totalSeetsInHall * normalTicketPrice;
            System.out.printf("%.2f leva", totalMoneyEarned);

        }else {
            double totalMoneyEarned = totalSeetsInHall * discountTicketPrice;
            System.out.printf("%.2f leva", totalMoneyEarned);

        }
    }
}