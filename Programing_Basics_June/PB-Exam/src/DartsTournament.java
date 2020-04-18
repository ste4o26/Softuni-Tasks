import java.util.Scanner;

public class DartsTournament {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int startingPoints = Integer.parseInt(sc.nextLine());

        String section = sc.nextLine();
        boolean isLoser = false;
        int moves = 1;

        while (!(section.equals("bullseye"))) {
            int points = Integer.parseInt(sc.nextLine());

            switch (section) {
                case "number section":
                    startingPoints -= points;
                    break;
                case "double ring":
                    startingPoints -= points * 2;
                    break;
                case "triple ring":
                    startingPoints -= points * 3;
                    break;
            }

            if (startingPoints <= 0) {
                if (startingPoints == 0) {
                    break;
                } else {
                    isLoser = true;
                    break;
                }
            }

            moves++;
            section = sc.nextLine();
        }


        if (!isLoser) {
            if (section.equals("bullseye")) {
                System.out.printf("Congratulations! You won the game with a bullseye in %d moves!", moves);
            } else {
                System.out.printf("Congratulations! You won the game in %d moves!", moves);
            }
        } else {
            System.out.printf("Sorry, you lost. Score difference: %d.", Math.abs(startingPoints));
        }
    }
}
