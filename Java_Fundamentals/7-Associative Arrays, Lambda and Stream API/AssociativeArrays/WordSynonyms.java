package AssociativeArrays;

import java.util.*;

public class WordSynonyms {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numberOfPairs = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> wordsSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < numberOfPairs; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();
            List<String> currentWordSynonyms = wordsSynonyms.get(word);

            if(wordsSynonyms.containsKey(word)){
                currentWordSynonyms.add(synonym);
            }else {
                currentWordSynonyms = new ArrayList<String>();
                currentWordSynonyms.add(synonym);
            }

            wordsSynonyms.put(word, currentWordSynonyms);
        }

        for (Map.Entry<String, List<String>> entry : wordsSynonyms.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            System.out.println(String.join(", ", entry.getValue()));
        }
    }
}
