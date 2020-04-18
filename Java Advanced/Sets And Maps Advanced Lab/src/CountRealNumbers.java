import java.util.*;

public class CountRealNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<Double, Integer> numbersOccurance = fillMap(sc.nextLine());
        numbersOccurance
                .forEach((k,v) -> System.out.printf("%.1f -> %d%n", k, v));
    }

    static LinkedHashMap<Double, Integer> fillMap(String input) {
        LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();
        String[] tokens = input.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            double number = Double.parseDouble(tokens[i]);
            if (map.containsKey(number)) {
                int newCount = map.get(number) + 1;
                map.put(number, newCount);
            } else {
                map.put(number, 1);
            }
        }
        return map;
    }
}