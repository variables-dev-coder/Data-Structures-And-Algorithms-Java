package Arrays.DSA_Counting_Sort;

// Count how many times each character appears in a string using counting sort logic.

// Logic:
// Create a frequency array of size 26 (for lowercase 'a' to 'z').
// Traverse the string and increment the count.
// Print the count of each character.

public class CharacterFrequency {

    public static void main(String[] args) {
        String str = "anagram";
        int[] count = new int[26]; // for a-z

        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                System.out.println((char) (i + 'a') + " = " + count[i]);
            }
        }
    }
}
