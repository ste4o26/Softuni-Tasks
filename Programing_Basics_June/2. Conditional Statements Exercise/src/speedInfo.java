import java.util.Scanner;

public class speedInfo {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        double speed = Double.parseDouble(sc.nextLine());

        boolean isSpeedSlow = speed <= 10;
        boolean isSpeedAvarage = speed > 10 && speed <= 50;
        boolean isSpeedFast = speed > 50 && speed <= 150;
        boolean isSpeedUltraFast = speed > 150 && speed <= 1000;

        if (isSpeedSlow) {
            System.out.println("slow");

        } else if (isSpeedAvarage){
            System.out.println("average");

        } else if (isSpeedFast){
            System.out.println("fast");

        } else if (isSpeedUltraFast){
            System.out.println("ultra fast");

        }else {
            System.out.println("extremely fast");
        }
    }
}

