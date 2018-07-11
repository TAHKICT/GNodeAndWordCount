package cisco.java.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordsCountService {

    public static Map<String, Integer> countWords(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("Input is empty");
        }

        Map<String, Integer> wordsMap = new HashMap<>();

        String[] words = input.split("\\s+");
        Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .map(word -> {
                    word = word.replaceAll("[\\.$|,|;|:|(|)|']", "");
                    return word;
                }).forEach(word -> {
                    if(wordsMap.containsKey(word)) {
                        int quantity = wordsMap.get(word);
                        wordsMap.put(word, ++quantity);
                    }else
                        wordsMap.put(word, 1);
                });

        System.out.println(Arrays.asList(words));
        return wordsMap;
    }
}
