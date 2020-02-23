import java.util.Scanner;
import java.util.Arrays;

public class ArrayManipulator2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputArray[] = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        arrayManipulation(inputArray, sc);

    }

    static void arrayManipulation(int array[], Scanner sc) {

        String input = sc.nextLine();

      //  int exchangedArray[] = new int[array.length];

        while (!input.equalsIgnoreCase("end")) {

            String comands[] = input.split("\\s+");

            boolean isEven = comands[1].equalsIgnoreCase("even");
            int count = 0;
            switch (comands[0]) {

                case "exchange":
                    int index = Integer.parseInt(comands[1]);

                    if (index < 0 || index >= array.length) {
                        System.out.println("Invalid index");
                    } else {
                        array = exchangeArray(array, index);//to do
                    }
                    break;

                case "max":

                    if (isEven) {
                        int maxEvenElementIndex = getMaxEvenElementIndex(array);
                        if (maxEvenElementIndex == -1) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(maxEvenElementIndex);
                        }

                    } else {
                        int maxOddElementIndex = getMaxOddElementIndex(array);
                        if (maxOddElementIndex == -1) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(maxOddElementIndex);
                        }
                    }

                    break;

                case "min":
                    if (isEven) {
                        int minEvenElementIndex = getMinEvenElementIndex(array);

                        if (minEvenElementIndex == -1) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(minEvenElementIndex);
                        }

                    } else {
                        int minOddElementIndex = getMinOddElementIndex(array);

                        if (minOddElementIndex == -1) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(minOddElementIndex);
                        }
                    }


                    break;
                case "first":
                    if (!isEmpty(comands, array) || !isGreater(comands, array)) {
                        count = Integer.parseInt(comands[1]);
                    }

                    if (comands[2].equalsIgnoreCase("even")) {

                        if (isEmpty(comands, array)) {
                            System.out.println("[]");
                        } else if (isGreater(comands, array)) {
                            System.out.println("Invalid count");
                        } else {
                            printFirstNEvenNumbers(array, count);
                        }

                    } else {
                        if (isEmpty(comands, array)) {
                            System.out.println("[]");
                        } else if (isGreater(comands, array)) {
                            System.out.println("Invalid count");
                        } else {
                            printFirstNOddNumbers(array, count);
                        }
                    }
                    break;

                case "last":
                    if (!isEmpty(comands, array) || !isGreater(comands, array)) {
                        count = Integer.parseInt(comands[1]);
                    }

                    if (comands[2].equalsIgnoreCase("even")) {

                        if (isEmpty(comands, array)) {
                            System.out.println("[]");
                        } else if (isGreater(comands, array)) {
                            System.out.println("Invalid count");
                        } else {
                            printLastNEvenNumbers(array, count);
                        }

                    } else {
                        if (isEmpty(comands, array)) {
                            System.out.println("[]");
                        } else if (isGreater(comands, array)) {
                            System.out.println("Invalid count");
                        } else {
                            printLastNOddNumbers(array, count);
                        }
                    }

                    break;
            }


            input = sc.nextLine();
        }

        printArray(array);
    }

    static void printArray(int array[]) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];

            if (i == array.length - 1) {
                System.out.printf("%d", currentNumber);
            }else {
                System.out.printf("%d, ", currentNumber);
            }
        }
        System.out.println("]");
    }

    static void printLastNOddNumbers(int array[], int count) {
        int currentCount = 1;
        System.out.print("[");
        for (int i = array.length - 1; i >= 0; i--) {
            int currentNumber = array[i];
            if (!(currentNumber % 2 == 0) && currentCount <= count) {
                if (currentCount == count) {
                    System.out.printf("%d", currentNumber);
                    count++;
                } else {
                    System.out.printf("%d, ", currentNumber);
                    count++;
                }
            }
        }
        System.out.println("]");
    }

    static void printLastNEvenNumbers(int array[], int count) {
        int currentCount = 1;
        System.out.print("[");
        for (int i = array.length - 1; i >= 0; i--) {
            int currentNumber = array[i];
            if (currentNumber % 2 == 0 && currentCount <= count) {
                if (currentCount == count) {
                    System.out.printf("%d", currentNumber);
                    count++;
                } else {
                    System.out.printf("%d, ", currentNumber);
                    count++;
                }
            }
        }
        System.out.println("]");
    }

    static boolean isEmpty(String commands[], int array[]) {
        int count = 0;
        try {
            count = Integer.parseInt(commands[1]);
        } catch (NumberFormatException nfe) {
            return false;
        }

        if (array.length <= 0) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isGreater(String commands[], int array[]) {

        int count = 0;
        try {
            count = Integer.parseInt(commands[1]);
        } catch (NumberFormatException nfe) {
            return false;
        }

        if (count >= array.length) {
            return true;
        } else {
            return false;
        }
    }

    static void printFirstNOddNumbers(int array[], int count) {
        int currentCount = 1;
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];

            if (!(currentNumber % 2 == 0) && currentCount <= count) {
                //                System.out.print(String.join(", ", String.valueOf(currentNumber)));

                if (currentCount == count) {
                    System.out.printf("%d", currentNumber);
                    currentCount++;
                } else {
                    System.out.printf("%d, ", currentNumber);
                    currentCount++;
                }
            }
        }
        System.out.println("]");
    }

    static void printFirstNEvenNumbers(int array[], int count) {
        int currentCount = 1;
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];

            if (currentNumber % 2 == 0 && currentCount <= count) {
                if (currentCount == count) {
                    System.out.printf("%d", currentNumber);
                    count++;
                } else {
                    System.out.printf("%d, ", currentNumber);
                    count++;
                }
            }
        }
        System.out.println("]");
    }

    static int getMinOddElementIndex(int array[]) {
        int minElement = Integer.MAX_VALUE;
        int bestIndex = -1;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            if (!(currentNumber % 2 == 0) && currentNumber < minElement) {
                minElement = currentNumber;
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    static int getMinEvenElementIndex(int array[]) {
        int minElement = Integer.MAX_VALUE;
        int bestIndex = -1;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            if (currentNumber % 2 == 0 && currentNumber < minElement) {
                minElement = currentNumber;
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    static int getMaxOddElementIndex(int array[]) {
        int maxElement = Integer.MIN_VALUE;
        int bestIndex = -1;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            if (!(currentNumber % 2 == 0) && currentNumber > maxElement) {
                maxElement = currentNumber;
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    static int getMaxEvenElementIndex(int array[]) {
        int maxElement = Integer.MIN_VALUE;
        int bestIndex = -1;

        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            if (currentNumber % 2 == 0 && currentNumber > maxElement) {
                maxElement = currentNumber;
                bestIndex = i;
            }
        }
        return bestIndex;
    }

    static int[] exchangeArray(int inputArray[], int index) {

        int exchangedArray[] = new int[inputArray.length];
        int firstPartOfArray[] = new int[index + 1];
        int secondPartOfArray[] = new int[inputArray.length - firstPartOfArray.length];


        for (int i = 0; i < firstPartOfArray.length; i++) {
            firstPartOfArray[i] = inputArray[i];
        }

        for (int i = 0; i < secondPartOfArray.length; i++) {
            secondPartOfArray[i] = inputArray[i + firstPartOfArray.length];
        }

       //1 3  5 7 9  ->
        for (int i = 0; i < exchangedArray.length; i++) {
            if(i < secondPartOfArray.length) {
                exchangedArray[i] = secondPartOfArray[i];
            }else {
                exchangedArray[i] = firstPartOfArray[i - secondPartOfArray.length];
            }
        }
        return exchangedArray;
//5 7 9 1 3 -> 3 5 7 9 1*/
    }
}
