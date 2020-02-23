package AssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> words = Arrays.stream(sc.nextLine().split(" "))
                .map(word -> word.toLowerCase())
                .collect(Collectors.toList());

        Map<String, Integer> wordsOccurrences = new LinkedHashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String currentWord = words.get(i);
            if(wordsOccurrences.containsKey(currentWord)){
                int wordCount = wordsOccurrences.get(currentWord) + 1;
                wordsOccurrences.put(currentWord, wordCount);
            }else {
                wordsOccurrences.put(currentWord, 1);
            }
        }

        List<String> filteredWords = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : wordsOccurrences.entrySet()) {
            if(!(entry.getValue() % 2 == 0)){
                filteredWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", filteredWords));
    }
}
