import java.util.Scanner;

public class HalfSumElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;

        for (int counter = 0; counter < n; counter++) {
            int number = Integer.parseInt(sc.nextLine());

            if(number > maxNum){
                maxNum = number;
            }

            sum += number;
        }

        int sumMinusMaxNum = sum - maxNum;

        if(sumMinusMaxNum == maxNum){
            System.out.println("Yes");
            System.out.println("Sum = " + sumMinusMaxNum);
        }else{
            int diff = Math.abs(maxNum - sumMinusMaxNum);
            System.out.println("No");
            System.out.println("Diff = " + diff);
        }
    }
}
