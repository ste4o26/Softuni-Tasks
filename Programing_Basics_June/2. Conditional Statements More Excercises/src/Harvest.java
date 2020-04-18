import java.util.Scanner;

public class Harvest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vineyardSquareMeters = Integer.parseInt(sc.nextLine());
        double grapesKGForSquareMeter = Double.parseDouble(sc.nextLine());
        int wineLitersNeeded = Integer.parseInt(sc.nextLine());
        int workers = Integer.parseInt(sc.nextLine());

        double grapesNeededForOneLiterWine = 2.50;

        double totalGrapesKg = grapesKGForSquareMeter * vineyardSquareMeters;
        double totalWineProduced = totalGrapesKg / grapesNeededForOneLiterWine * 0.40;

        boolean isWineEnough = totalWineProduced < wineLitersNeeded;

        if(!isWineEnough){
            double leftWine = totalWineProduced - wineLitersNeeded;
            double litersWinePerPerson = leftWine / workers;

            System.out.printf("Good harvest this year! Total wine: %.0f liters.\n", Math.floor(totalWineProduced));
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(leftWine), Math.ceil(litersWinePerPerson));

        }else{
            double wineNeeded = wineLitersNeeded - totalWineProduced;
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(wineNeeded));

        }
    }
}
