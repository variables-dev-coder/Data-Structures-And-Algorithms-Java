package revision13;

import java.util.HashSet;

public class UniqueMorseCode {

    public static int uniqueMorseRepresentations(String[] words) {

        String[] morse = {
                ".-","-...","-.-.","-..",".","..-.","--.","....",
                "..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-",".-.","...","-","..-","...-",".--","-..-",
                "-.--","--.."
        };

        HashSet<String> set = new HashSet<>();

        for (String word : words) {

            StringBuilder sb = new StringBuilder();

            for (char ch : word.toCharArray()) {
                sb.append(morse[ch - 'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }

    public static void main(String[] args) {

        String[] words = {
                "gin","zen","gig","msg"
        };

        System.out.println(uniqueMorseRepresentations(words));
    }
}
