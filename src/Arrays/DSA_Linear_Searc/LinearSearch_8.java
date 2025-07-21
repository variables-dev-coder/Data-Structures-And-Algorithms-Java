package Arrays.DSA_Linear_Searc;


// Search for a Character in a String using Linear Search
// Given a string and a target character, check if the character exists
// in the string using linear search. Optionally, return the index of first occurrence.


public class LinearSearch_8 {
    public static int searchChar(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target){
                return i; // first Occurrence found
            }
        }
        return -1; // Character not fount
    }

    public static void main(String[] args) {
        String str = "munna";
        char target = 'n';

        int index = searchChar(str, target);

        if (index  != -1)
            System.out.println("Character '" + target + "' found at index: " + index);
        else
            System.out.println("Character not found!");

    }
}
