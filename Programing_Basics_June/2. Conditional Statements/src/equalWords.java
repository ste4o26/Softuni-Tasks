import java.util.Scanner;

public class equalWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String firstWord = sc.nextLine();
        String secondWord = sc.nextLine();

        boolean areWordsEquals = firstWord.equalsIgnoreCase(secondWord);

        if(areWordsEquals){
            System.out.println("yes");

        }else {
            System.out.println("no");

        }
    }
}
