import java.util.Scanner;
public class VowelsCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //vowels in english are A, E, I, O, U
        //1 read one string
        //2 switch the string and look for those particular letters... found letter means + 1 vowel

        String input = sc.nextLine().toUpperCase();
        int totalVowels = countVowels(input);
        System.out.println(totalVowels);
    }

    static int countVowels(String word){
        int totalVowels = 0;

        for (int i = 0; i < word.length(); i++) {

            boolean isVowelLetter = word.charAt(i) == 'A' ||
                    word.charAt(i) == 'E' ||
                    word.charAt(i) == 'I' ||
                    word.charAt(i) == 'O' ||
                    word.charAt(i) == 'U';

            if(isVowelLetter){
                totalVowels++;
            }
        }
        return totalVowels;
    }
}
