package HASH_TABLES;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple";

        // Create a HashMap to store word -> frequency
        Map<String, Integer> wordCount = new HashMap<>();

        // Split text into words
        String[] words = text.split(" ");

        // Count each word
        for (String word : words) {
            // If word already exists, increment count
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                // If word not in map, set count to 1
                wordCount.put(word, 1);
            }
        }

        // Print word frequencies
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
/*
apple -> 3
banana -> 2
orange -> 1


How this uses Hash Table concept
Key = Word (String)
Value = Count (Integer)
Internally, HashMap uses a hash function to store and retrieve word counts in O(1) average time.
 */