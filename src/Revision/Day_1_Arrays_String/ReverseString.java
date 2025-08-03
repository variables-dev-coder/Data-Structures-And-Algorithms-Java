package Revision.Day_1_Arrays_String;

public class ReverseString {
    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("Reversed String: " + reverse("Hello"));
    }
}
