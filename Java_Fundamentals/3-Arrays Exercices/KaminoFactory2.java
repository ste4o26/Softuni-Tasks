import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dnaLength = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        int bestSequenceIndex = dnaLength - 1;
        int bestSequenceSum = 0;
        int bestSequence = 0;
        int currentIndex = 0;
        int bestSequenceList[] = new int[dnaLength];

        while (!input.equals("Clone them!")) {

           int sequence[] = Arrays.stream(input.split("!"))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            for (int firstIndex = 0; firstIndex < sequence.length; firstIndex++) {

                int currentSequence = 0;

                for (int secondIndex = firstIndex; secondIndex < sequence.length; secondIndex++) {


                    if (sequence[firstIndex] == sequence[secondIndex]) {
                        currentSequence++;

                        if (currentSequence > bestSequence) {
                            bestSequence = currentSequence;
                            currentIndex = firstIndex;
                        }
                    } else {
                        break;
                    }
                }
            }

            int currentSum = 0;
            for (int i = 0; i < sequence.length; i++) {
                currentSum += sequence[i];
            }

            if(bestSequenceIndex > currentIndex || currentSum > bestSequenceSum){
                bestSequenceIndex = currentIndex;
                bestSequenceSum = currentSum;

                for (int i = 0; i < bestSequenceList.length; i++) {
                     bestSequenceList[i] = sequence[i];
                }
            }


            


            input = sc.nextLine();

        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex + 1, bestSequenceSum);

        for (int i = 0; i < bestSequenceList.length; i++) {
            System.out.printf("%d ", bestSequenceList[i]);
        }
    }
}
