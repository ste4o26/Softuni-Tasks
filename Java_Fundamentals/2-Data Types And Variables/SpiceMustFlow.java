import java.util.Scanner;
public class SpiceMustFlow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int startingYield = Integer.parseInt(sc.nextLine());
        int workerConsumation = 26;
        int workersIncome = 0;
        int daysCounter = 0;

        for (int currentYield = startingYield; currentYield >= 100; currentYield-=10) {
            workersIncome += (currentYield - workerConsumation);
            daysCounter++;
        }

        //usloviqta ne sa im pulni trqbva da gadaq :D !!!
        if(workersIncome >= workerConsumation){
            workersIncome -= workerConsumation;
        }

        System.out.println(daysCounter);
        System.out.println(workersIncome);
    }
}
