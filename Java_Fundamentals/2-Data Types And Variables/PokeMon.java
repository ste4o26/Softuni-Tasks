import java.util.Scanner;
public class PokeMon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int pokePowerN = Integer.parseInt(sc.nextLine());
        int targetDistanceM = Integer.parseInt(sc.nextLine());
        int exhaustionFactoryY = Integer.parseInt(sc.nextLine());

        int pokesCounter = 0;
        int currentPokePowerN = pokePowerN;
        int criticPoint = pokePowerN / 2;

        while(currentPokePowerN >= targetDistanceM){

            currentPokePowerN -= targetDistanceM;
            pokesCounter++;

            //proverqvame dali y e po golqmo ot 0 poneje pri celochisleni deleniq na 0 poluchavam exception!!!
            if(currentPokePowerN == criticPoint && exhaustionFactoryY > 0){
                currentPokePowerN /= exhaustionFactoryY;
            }


        }

        System.out.println(currentPokePowerN);
        System.out.println(pokesCounter);
    }
}
