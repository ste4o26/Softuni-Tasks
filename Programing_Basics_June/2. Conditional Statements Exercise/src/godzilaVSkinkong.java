import java.util.Scanner;

public class godzilaVSkinkong {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1 read input
        //2 dekor is 10% of the budget
        //3 chek if statist > 150 to aply 10% off

        double movieBudget = Double.parseDouble(sc.nextLine());
        int statists = Integer.parseInt(sc.nextLine());
        double statistOutfitPrice = Double.parseDouble(sc.nextLine());

        double totalStatistsOutfitPrice = statistOutfitPrice * statists;

        double decorationPrice = movieBudget * 0.1;
        boolean areStatistsMoreThen150 = statists > 150;

        if(areStatistsMoreThen150){
           totalStatistsOutfitPrice = totalStatistsOutfitPrice * 0.9;
        }

        double moneyNeededForMovie = decorationPrice + totalStatistsOutfitPrice;
        boolean areMoneyEnough = movieBudget >= moneyNeededForMovie;

        if(areMoneyEnough){
            System.out.printf("Action!\nWingard starts filming with %.2f leva left.", movieBudget - moneyNeededForMovie);

        }else{
            System.out.printf("Not enough money!\nWingard needs %.2f leva more.", Math.abs(movieBudget - moneyNeededForMovie));
        }
    }
}
