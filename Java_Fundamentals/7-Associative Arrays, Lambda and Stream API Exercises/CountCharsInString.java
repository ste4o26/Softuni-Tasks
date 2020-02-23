import java.util.*;
import java.util.stream.Collectors;

public class CountCharsInString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Map<Character, Integer> letterCount = new LinkedHashMap<Character, Integer>();
        mapLettersWithTheirCount(letterCount, words);
        printMap(letterCount);
    }

    static void printMap(Map<Character, Integer> letterCount){
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }

    static void mapLettersWithTheirCount(Map<Character, Integer> letterCount, List<String> words){
        for (String word : words) {
            for (int currentLetterIndex = 0; currentLetterIndex < word.length(); currentLetterIndex++) {
                char currentLetter = word.charAt(currentLetterIndex);
                if(letterCount.containsKey(currentLetter)){
                    int currentLetterCount = letterCount.get(currentLetter);
                    letterCount.put(currentLetter, currentLetterCount + 1);
                }else {
                    letterCount.put(currentLetter, 1);
                }
            }
        }
    }
}
