import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> input = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        randomizeSentance(input);
        printList(input);
    }

    static void randomizeSentance(List<String> listOfWords){
        Random random = new Random();

        for (int i = 0; i < listOfWords.size() - 1; i++) {
            int firstRandomIndex = random.nextInt(listOfWords.size());
            int secondRandomIndex = random.nextInt(listOfWords.size());
            swap(listOfWords, firstRandomIndex, secondRandomIndex);
        }
    }

    static void swap(List<String> list, int firstIndex, int secondIndex){
        String temp = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, temp);
    }

    static void printList(List<String> listOfWords){
        for (String element : listOfWords) {
            System.out.println(element);
        }
    }
}
