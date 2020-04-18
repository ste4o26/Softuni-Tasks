import java.util.Scanner;

public class MaxNumber {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int countNumbers = Integer.parseInt(sc.nextLine());
        int number = Integer.parseInt(sc.nextLine());
        int maxNum = number;
        int count = 1;

        while (count != countNumbers){
            number = Integer.parseInt(sc.nextLine());

            if(number > maxNum) {
                maxNum = number;
            }


            count ++;
        }

        System.out.println(maxNum);
    }

}
