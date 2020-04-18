import java.util.Scanner;

public class SpaceShip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double spaceShipWidht = Double.parseDouble(sc.nextLine());
        double spaceShipLen = Double.parseDouble(sc.nextLine());
        double spacShipHeight = Double.parseDouble(sc.nextLine());
        double averageAoustronoughtsHeight = Double.parseDouble(sc.nextLine());

        double spaceShipVolume = spaceShipLen * spaceShipWidht * spacShipHeight;

        double spaceNeededForOneAoustronought = 2 * 2 * (averageAoustronoughtsHeight + 0.40);
        double numberOfAustronoughts = Math.floor(spaceShipVolume / spaceNeededForOneAoustronought);

        boolean areAoustronoughtsless = numberOfAustronoughts < 3;
        boolean areAoustrounoughtsEnough = numberOfAustronoughts >= 3 && numberOfAustronoughts <= 10;

        if(areAoustrounoughtsEnough){
            System.out.printf("The spacecraft holds %.0f astronauts.", numberOfAustronoughts);

        }else if(areAoustronoughtsless){
            System.out.print("The spacecraft is too small.");

        }else{
            System.out.print("The spacecraft is too big.");

        }


    }
}
