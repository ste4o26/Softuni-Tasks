import java.util.Scanner;
public class Train {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numberOfWagons = Integer.parseInt(sc.nextLine());
        int trainWagons[] = new int[numberOfWagons];
        int peopleInTrain = 0;

        for (int currentWagon = 0; currentWagon < trainWagons.length; currentWagon++) {
            int peopleInWagon = Integer.parseInt(sc.nextLine());

            trainWagons[currentWagon] = peopleInWagon;
            peopleInTrain += peopleInWagon;
        }

        for(int currentWagonPeople : trainWagons){
            System.out.printf("%d ", currentWagonPeople);
        }

        System.out.printf("%n%d", peopleInTrain);
    }
}
