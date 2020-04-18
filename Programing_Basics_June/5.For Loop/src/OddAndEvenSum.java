import java.util.Scanner;

public class OddAndEvenSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int evenPositionSum = 0;
        int oddPositionSum = 0;


        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(sc.nextLine());

            if(i % 2 == 0){
                evenPositionSum += number;
            }else{
                oddPositionSum += number;
            }
        }

        if(evenPositionSum == oddPositionSum){
            System.out.println("Yes");
            System.out.println("Sum = " + evenPositionSum);
        }else{
            System.out.println("No");
            System.out.println("Diff = " + Math.abs(evenPositionSum - oddPositionSum));
        }
    }
}
