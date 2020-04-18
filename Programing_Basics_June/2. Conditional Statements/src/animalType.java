import java.util.Scanner;

public class animalType {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String animal = sc.nextLine();

        boolean isMammal = animal.equals("dog");
        boolean isReptile = animal.equals("crocodile") || animal.equals("tortoise") || animal.equals("snake");

        if (isMammal) {
            System.out.println("mammal");

        } else if (isReptile) {
            System.out.println("reptile");

        } else {
            System.out.println("unknown");
        }
    }
}