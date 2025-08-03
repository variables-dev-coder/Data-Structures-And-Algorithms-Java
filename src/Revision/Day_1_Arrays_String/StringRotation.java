package Revision.Day_1_Arrays_String;

public class StringRotation {
    public static boolean isRotation(String A, String B) {
        if (A.length() != B.length()) return false;
        return (A + A).contains(B);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("abcde", "deabc"));  // true
    }
}
