import java.util.Scanner;
public class AddAndSubstract {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numbers[] = new int[3];

        fillArray(numbers, sc);
        int sum = sumOfFirstTwoNumbers(numbers);
        int answer = subtract(sum, numbers);
        System.out.println(answer);
    }

    static void fillArray(int numbers[], Scanner sc){
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
    }

    static int sumOfFirstTwoNumbers(int numbers[]){
        int sum = numbers[0] + numbers[1];
        return sum;
    }

    static int subtract(int sum, int numbers[]){
        int sumAfterSubtraction = sum - numbers[2];
        return sumAfterSubtraction;
    }
}
