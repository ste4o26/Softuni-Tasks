import java.util.Scanner;

public class EqualSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input[] = sc.nextLine().split(" ");

        int numbers[] = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }


        int rightSum = 0;
        int leftSum = 0;
        boolean areEqualSums = false;
        int separatorIndex = 0;

        for (int i = 0; i < numbers.length; i++) {

            for (int leftNumberIndex = 0; leftNumberIndex < i ; leftNumberIndex++) {
                leftSum += numbers[leftNumberIndex];
            }

            for (int rightNumberIndex = numbers.length-1; rightNumberIndex > i; rightNumberIndex--) {
                rightSum += numbers[rightNumberIndex];
//                  System.out.printf("%d ", numbers[rightNumberIndex]);
            }

            if(rightSum == leftSum){
                areEqualSums = true;
                separatorIndex = i;
                break;
            }else{
                rightSum = 0;
                leftSum = 0;
            }
        }

        if(areEqualSums){
            System.out.println(separatorIndex);
        }else if(numbers.length == 1){
            System.out.println(0);
        }else {
            System.out.println("no");
        }
    }
}
