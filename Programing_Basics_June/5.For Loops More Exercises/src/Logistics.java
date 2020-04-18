import java.util.Scanner;

public class Logistics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int loryPrice = 175;
        int trainPrice = 120;
        int microbussPrice = 200;

        double averagePricePerTon;
        double loryPorcentage;
        double trainPorcentage;
        double microbussPorcentage;

        double totalPrice = 0;
        double totalTrainLoads = 0;
        double totalLoryLoads = 0;
        double totalMicrobussLoads = 0;

        int numberOfLoads = Integer.parseInt(sc.nextLine());

        for (int load = 0; load < numberOfLoads; load++) {
            int loadTons = Integer.parseInt(sc.nextLine());

            if(loadTons >= 12){
                totalTrainLoads += loadTons;
            }else if(loadTons >= 4){
                totalLoryLoads += loadTons;
            }else {
                totalMicrobussLoads += loadTons;
            }
        }


        double totalLoads = totalLoryLoads + totalMicrobussLoads + totalTrainLoads;

        averagePricePerTon = ((totalLoryLoads * loryPrice) + (totalMicrobussLoads * microbussPrice) + (totalTrainLoads * trainPrice)) / totalLoads;


        loryPorcentage = totalLoryLoads / totalLoads * 100;
        trainPorcentage = totalTrainLoads / totalLoads * 100;
        microbussPorcentage = totalMicrobussLoads / totalLoads * 100;

        System.out.printf("%.2f%n", averagePricePerTon);
        System.out.printf("%.2f%c%n", microbussPorcentage, '%');
        System.out.printf("%.2f%c%n", loryPorcentage, '%');
        System.out.printf("%.2f%c", trainPorcentage, '%');

    }
}
