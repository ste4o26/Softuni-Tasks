import java.util.Scanner;

public class Journey {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //read input
        //check the budget of the programer and if the budget is more than 1000 the journey will be at hotel
        //check the season

        double budget = Double.parseDouble(sc.nextLine());
        String season = sc.nextLine();

        boolean isBudget100OrLess = budget <= 100;
        boolean isBudget1000OrLess = budget > 100 && budget <= 1000;
        boolean isBudgetMoreThan1000 = budget > 1000;

        boolean isSummer = season.equals("summer");
        boolean isWinter = season.equals("winter");

        double moneyToBeSpend = 0;

        if(isBudget100OrLess){
            if(isSummer){
                moneyToBeSpend = budget * 0.3;
                System.out.println("Somewhere in Bulgaria");
                System.out.printf("Camp - %.2f", moneyToBeSpend);
            }else {
                moneyToBeSpend = budget * 0.7;
                System.out.println("Somewhere in Bulgaria");
                System.out.printf("Hotel - %.2f", moneyToBeSpend);

            }

        }else if(isBudget1000OrLess){
            if(isSummer){
                moneyToBeSpend = budget * 0.4;
                System.out.println("Somewhere in Balkans");
                System.out.printf("Camp - %.2f", moneyToBeSpend);


            }else{
                moneyToBeSpend = budget * 0.8;
                System.out.println("Somewhere in Balkans");
                System.out.printf("Hotel - %.2f", moneyToBeSpend);


            }

        }else if(isBudgetMoreThan1000){
            if(isSummer){
                moneyToBeSpend = budget * 0.9;
                System.out.println("Somewhere in Europe");
                System.out.printf("Hotel - %.2f", moneyToBeSpend);


            }else {
                moneyToBeSpend = budget * 0.9;
                System.out.println("Somewhere in Europe");
                System.out.printf("Hotel - %.2f", moneyToBeSpend);


            }

        }
    }
}
