import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BombNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> bombInfo = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int bombNumber =bombInfo.get(0);
        int power = bombInfo.get(1);

        detonateAllBombNumbers(listOfNumbers, bombNumber, power);
        printListSum(listOfNumbers);
    }

    static void detonateAllBombNumbers(List<Integer> listOfNumbers, int bombNumber, int power) {
        while (listOfNumbers.contains(bombNumber)) {
            int bombIndex = listOfNumbers.indexOf(bombNumber);
            destroyNeighbours(listOfNumbers, power, bombIndex);
        }
    }

    static void destroyNeighbours(List<Integer> listOfNumbers, int power, int currentBombIndex) {
        int leftBound = Math.max(0, currentBombIndex - power);//ako izpolzvam Math.abs v izraza : Math.abs(power - currentBombIndex) burzodeistvieto na programata mi se zabavq dosta
        int rightBound = Math.min(listOfNumbers.size() - 1, power + currentBombIndex);

        for (int i = rightBound; i >= leftBound; i--) {
            listOfNumbers.remove(i);
        }
    }

    static void printListSum(List<Integer> listOfNumbers) {
        int sum = 0;
        for (int element : listOfNumbers) {
            sum += element;
        }
        System.out.println(sum);
    }
}
