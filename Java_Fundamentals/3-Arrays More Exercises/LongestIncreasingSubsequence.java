import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] listOfNumbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        printLIS(listOfNumbers);
    }

    static void printLIS(int[] listOfNumbers) {
        int[] bestLength = new int[listOfNumbers.length];
        int[] prevBestIndex = new int[listOfNumbers.length];
        int bestIndex = -1;
        int maxLength = 0;

        for (int i = 0; i < listOfNumbers.length; i++) {
            bestLength[i] = 1;//sluji za sravnenie na tekushtata duljina s maxLength
            prevBestIndex[i] = -1;//kogato e polovitelen index znachi ima posledovatelnost pri printirane zapochvame ot posledniq polojitelen(bestIndex) i stigame do posledniq polovitelen v poredica koito e maxLength - 1

            for (int j = 0; j < i; j++) {
                if (listOfNumbers[j] < listOfNumbers[i] && bestLength[j] + 1 > bestLength[i]){
                    //sravnqvam dali chisloto za tekushtata iteraciq e po malko
                    // ot chisloto na indexa na tekushtata iteraciq NA PURVIQ FOR
                    //i dali daljinata na subsequenca na tekushtata iteraciq + 1
                    // e po golqma ot tazi na tekushtata iteraciq na parviq for

                    bestLength[i] = bestLength[j] + 1;
                    prevBestIndex[i] = j;
                }
            }
            if(bestLength[i] > maxLength){
                maxLength = bestLength[i];
                bestIndex = i;
            }
        }
        int[] lis = new int[maxLength];
        int currentIndex = maxLength - 1;

        //prisvoqvam stoinostite ot zad na pred
        while (bestIndex != -1){

            lis[currentIndex] = listOfNumbers[bestIndex];
            currentIndex--;
            bestIndex = prevBestIndex[bestIndex];
        }

        for (int i = 0; i < lis.length; i++) {
            System.out.print(lis[i] + " ");
        }
    }
}
