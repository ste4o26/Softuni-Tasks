import java.util.Scanner;

public class Sequence2kPlus1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = Integer.parseInt(sc.nextLine());

        int n = 1;

        while(number >= n){
            System.out.println(n);

            n = n * 2 +1;
        }
    }
}
