import java.util.Scanner;

public class NameWars {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int maxAsciiSum = 0;
        String maxSumName = null;

        while (!(name.equals("STOP"))){

            int characterValue = 0;
            int asciiSum = 0;

            for (int index = 0; index < name.length(); index++) {
                characterValue = name.charAt(index);
                asciiSum += characterValue;
            }

            if(asciiSum > maxAsciiSum){
                maxAsciiSum = asciiSum;
                maxSumName = name;
            }

            name = sc.nextLine();
        }
        System.out.printf("Winner is %s - %d!", maxSumName, maxAsciiSum);
    }
}
