import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputText = reader.readLine();
        Map<Character, Integer> symbolsCount = new TreeMap<>();
        for (int i = 0; i < inputText.length(); i++) {
            char currentSymbol = inputText.charAt(i);
            if (!symbolsCount.containsKey(currentSymbol)){
                symbolsCount.put(currentSymbol, 1);
            }else {
                int newCount = symbolsCount.get(currentSymbol) + 1;
                symbolsCount.put(currentSymbol, newCount);
            }
        }

        symbolsCount.forEach((key, value) -> System.out.printf("%s: %d time/s%n", key, value));
    }
}
