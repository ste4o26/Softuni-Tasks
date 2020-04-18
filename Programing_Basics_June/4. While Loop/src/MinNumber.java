import java.util.Scanner;

public class MinNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int countNumbers = Integer.parseInt(sc.nextLine());
        int number = Integer.parseInt(sc.nextLine());
        int minNum = number;
        int count = 1;

        while (count != countNumbers){
            number = Integer.parseInt(sc.nextLine());

            if(number < minNum) {
                minNum = number;
            }


            count ++;
        }

        System.out.println(minNum);
    }
}
