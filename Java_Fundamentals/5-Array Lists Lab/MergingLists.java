import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> firstListOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondListOfNumbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> mergedList = mergingPairOfLists(firstListOfNumbers, secondListOfNumbers);
        printList(mergedList);

    }

    static void printList(List<Integer> list){
        for (int element : list) {
            System.out.print(element + " ");
        }
    }

    static List<Integer> mergingPairOfLists(List<Integer> firstListOfNumbers, List<Integer> secondListOfNumbers){
        List<Integer> mergedList = new ArrayList<>();
        int maxLength = Math.max(firstListOfNumbers.size(), secondListOfNumbers.size());
        for (int i = 0; i < maxLength; i++) {
            if(i < firstListOfNumbers.size()){
                mergedList.add(firstListOfNumbers.get(i));
            }
            if(i < secondListOfNumbers.size()){
                mergedList.add(secondListOfNumbers.get(i));
            }
        }
        return mergedList;
    }
}
