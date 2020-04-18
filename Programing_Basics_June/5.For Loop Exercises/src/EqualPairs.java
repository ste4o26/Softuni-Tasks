import java.util.Scanner;

public class EqualPairs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int lastSum = 0;
        int maxDiff = Integer.MIN_VALUE;

        int currentSum;
        int currentDiff;

        for (int i = 0; i < n; i++) {
            int firstNumber = Integer.parseInt(sc.nextLine());
            int secondNumber = Integer.parseInt(sc.nextLine());

            currentSum = firstNumber + secondNumber;

            //prisvoqvam tekushtata suma kum poslednata v nachaloto samo pri purvata iteraciq za da nqmam razlika
            //poneje tova e problem zashtoto fakticheski az nqmam predishna stoinost pri pyrvata iteraciq
            if(i == 0){
                lastSum = currentSum;
            }

            if(currentSum != lastSum){
                currentDiff = Math.abs(currentSum - lastSum);
                if(currentDiff > maxDiff){
                    maxDiff = currentDiff;
                }
            }

            lastSum = currentSum;
        }

        boolean isDifference = maxDiff > 0;

        if(isDifference){
            System.out.printf("No, maxdiff=%d", maxDiff);
        }else {
            System.out.printf("Yes, value=%d", lastSum);
        }
    }
}
