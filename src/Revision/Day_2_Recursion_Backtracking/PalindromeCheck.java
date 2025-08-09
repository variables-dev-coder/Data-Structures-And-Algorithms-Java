package Revision.Day_2_Recursion_Backtracking;

public class PalindromeCheck {
    public static boolean isPalindrome(String str, int left, int right) {
        // Base case: single char or empty subString
        if(left >= right) {
            return true;
        }
        // If mismatch found
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        // Move towards the middle
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String str = "madam";
        boolean result = isPalindrome(str, 0, str.length() - 1);
        System.out.println(str + " is palindrome? " + result);
    }
}
