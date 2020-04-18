import java.util.Scanner;

public class Cake {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cakeWidth = Integer.parseInt(sc.nextLine());
        int cakeHeight = Integer.parseInt(sc.nextLine());

        int cakeSquareCM = cakeHeight * cakeWidth;

        int peacesSum = 0;

        String str = null;
        int numberOfPieces = 0;

        boolean isEnough = false;

        while(peacesSum <= cakeSquareCM){

            str = sc.nextLine();
            if(str.equals("STOP")){
                isEnough = true;
                break;
            }

            numberOfPieces = Integer.parseInt(str);
            peacesSum += numberOfPieces;
        }

        int peacesLeft = Math.abs(cakeSquareCM - peacesSum);

        if(isEnough){
            System.out.printf("%d pieces are left.", peacesLeft);

        }else{
            System.out.printf("No more cake left! You need %d pieces more.", peacesLeft);

        }

    }
}
