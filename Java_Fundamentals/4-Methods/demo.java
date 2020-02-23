import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.Scanner;
import java.util.Arrays;

public class demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numbers[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = Integer.parseInt(sc.nextLine());

        //reverseArray(numbers);
        arrExchange(numbers, index);
    }

    static void reverseArray(int numbers[]) {
        int exchangedArray[] = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            for (int j = i; j < numbers.length; j++) {
                exchangedArray[numbers.length - i - 1] = currentNumber;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d, ", exchangedArray[i]);
        }
    }


    /*void exchangeArray(int initialArray[], int index) {
        int[] firstArray = new int[index + 1];
        int[] secondArray = new int[(initialArray.length - firstArray.length)];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = initialArray[i];
        }
        for (int i = 1; i <= secondArray.length; i++) {
            secondArray[i - 1] = initialArray[(firstArray.length - 1) + i];
        }
        for (int i = 0; i < secondArray.length; i++) {
            initialArray[i] = secondArray[i];
        }
        for (int i = 0; i < firstArray.length; i++) {
            initialArray[secondArray.length + i] = firstArray[i];
        }
        return initialArray;
    }
    */
    static void arrExchange(int array[], int index) {
        //   int firstArr[] = new int[index + 1];
        //int secondArr[] = new int[array.length - firstArr.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = index; j >= 0; j--) {
//1 3 5 7 9 - >
                if (i < index) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d, ", array[i]);
        }
    }
}
