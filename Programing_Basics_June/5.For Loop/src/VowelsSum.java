import java.util.Scanner;

public class VowelsSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        String word = sc.nextLine().toLowerCase();
        int length = word.length();
        int vowelSum = 0;

        for (int index = 0; index < length; index++) {
            char character = word.charAt(index);

            switch (character){
                case 'a':vowelSum += 1;
                        break;

                case 'e':vowelSum += 2;
                        break;

                case 'i':vowelSum += 3;
                        break;

                case 'o':vowelSum += 4;
                        break;

                case 'u':vowelSum += 5;
                        break;

            }
        }
        System.out.println(vowelSum);
    }
}
