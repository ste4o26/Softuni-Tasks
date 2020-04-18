import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfMatches = 0;
        Deque<Integer> males = new ArrayDeque<>(); // stack
        String[] tokens = reader.readLine().split("\\s+");
        for (String token : tokens) {
            males.push(Integer.parseInt(token));
        }

        Deque<Integer> females = Arrays.stream(reader.readLine().split("\\s+")) // queue
                .map(Integer::parseInt)
                .collect(Collectors
                        .toCollection(ArrayDeque::new));

        while (!(males.isEmpty() || females.isEmpty())) {
            Integer male = males.peek();
            Integer female = females.peek();

            if (male != null && female != null) {

                if (male <= 0) {
                    males.pop();
                } else if (female <= 0) {
                    females.poll();
                } else {

                    if (male % 25 == 0) {
                        males.pop();
                        males.pop();
                        continue;
                    } else if (female % 25 == 0) {
                        females.poll();
                        females.poll();
                        continue;
                    }

                    if (female.equals(male)) {
                        males.pop();
                        females.poll();
                        numberOfMatches++;
                    } else {
                        females.poll();
                        Integer newMale = males.pop() - 2;
                        males.push(newMale);
                    }


                }
            }
        }

        System.out.println(String.format("Matches: %d", numberOfMatches));
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            printMales(males);
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            printFemales(females);
        }
    }

    private static void printMales(Deque<Integer> males) {
        while (!males.isEmpty()){
            Integer member = males.pop();
            if (males.isEmpty()) {
                System.out.println(member);
            } else {
                System.out.print(member + ", ");
            }
        }
    }

    private static void printFemales(Deque<Integer> females) {
        while (!females.isEmpty()){
            Integer member = females.poll();
            if (females.isEmpty()) {
                System.out.println(member);
            } else {
                System.out.print(member + ", ");
            }
        }

    }
}
