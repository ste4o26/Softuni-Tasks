import java.util.Scanner;
public class SmallestOfThreeNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1 read three numbers and put them into an array
        //2 compare numbers from the array and print the smallest one

        int numbers[] = new int[3];

        fillArray(numbers, sc);
        int minValue = getMinNumber(numbers);
        System.out.println(minValue);
    }

    static int getMinNumber(int numbers[]){
        int smallestNumber = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < smallestNumber){
                smallestNumber = numbers[i];
            }
        }
        return smallestNumber;
    }

    static void fillArray(int numbers[], Scanner sc){
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
    }
}
