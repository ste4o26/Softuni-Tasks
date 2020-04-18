import java.util.Scanner;

public class danceHall {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double hallLen = Double.parseDouble(sc.nextLine());
        double hallWidth = Double.parseDouble(sc.nextLine());
        double wardropeSide = Double.parseDouble(sc.nextLine());

        double hallArea = hallLen * hallWidth;
        double benchArea = hallArea / 10;
        double wardropeArea =  wardropeSide * wardropeSide;
        double dancerArea = (40 + 7000) * 0.0001;
        double freeArea = hallArea - (benchArea + wardropeArea);
        double totalDancers = freeArea / dancerArea;

        System.out.printf("%.0f", Math.floor(totalDancers));
    }
}
