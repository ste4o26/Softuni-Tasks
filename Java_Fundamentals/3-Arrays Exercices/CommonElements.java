import java.util.Scanner;
public class CommonElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //create 2 arr of strings
        //split the read input into those arrays by space
        //compare them
        //print equal values

        String firstArray[] = sc.nextLine().split(" ");
        String secondArray[] = sc.nextLine().split(" ");

        for (int currentWord = 0; currentWord < secondArray.length; currentWord++) {

            for (String word : firstArray) {
                if (word.equals(secondArray[currentWord])){
                    System.out.printf("%s ", word);
                }
            }
        }
    }
}
