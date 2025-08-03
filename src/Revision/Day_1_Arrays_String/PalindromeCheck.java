package Revision.Day_1_Arrays_String;

public class PalindromeCheck {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println("Is Palindrome: " + isPalindrome(str));
    }
}
