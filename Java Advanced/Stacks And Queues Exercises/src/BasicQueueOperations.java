import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] tokens = sc.nextLine().split("\\s+");
        int elementsToOffer = Integer.parseInt(tokens[0]);
        int elementsToPoll = Integer.parseInt(tokens[1]);
        int elementToCheckIsPresenting = Integer.parseInt(tokens[2]);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();

        fillQueue(queue, elementsToOffer, numbers);
        pollElements(queue, elementsToPoll);
        if (queue.isEmpty()){
            System.out.println(0);
        }else if (isElementPresent(queue, elementToCheckIsPresenting)){
            System.out.println("true");
        }else {
            int smallestNumber = smallestElement(queue);
            System.out.println(smallestNumber);
        }
    }

    static void fillQueue(ArrayDeque<Integer> queue, int elementsToPush, int[] numbers){
        for (int i = 0; i < elementsToPush; i++) {
            queue.offer(numbers[i]);
        }
    }

    static void pollElements(ArrayDeque<Integer> queue, int elementsToPop){
        for (int i = 0; i < elementsToPop; i++) {
            queue.poll();
        }
    }

    static boolean isElementPresent(ArrayDeque<Integer> queue, int element){
        if (queue.contains(element)){
            return true;
        }else {
            return false;
        }
    }

    static int smallestElement(ArrayDeque<Integer> queue){
        int minElement = queue.poll();
        while (!queue.isEmpty()){
            int currentElement = queue.poll();
            if (currentElement < minElement){
                minElement = currentElement;
            }
        }
        return minElement;
    }
}
