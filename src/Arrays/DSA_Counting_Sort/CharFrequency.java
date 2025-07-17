package Arrays.DSA_Counting_Sort;


// Find Frequency of Characters in a String
// Used in Anagram, Longest Palindrome, etc.

public class CharFrequency {
    public static void main(String[] args) {
        String str = "anagram";
        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                System.out.println((char)(i + 'a') + " = " + freq[i]);
        }
    }
}
