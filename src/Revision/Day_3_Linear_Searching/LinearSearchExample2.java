package Revision.Day_3_Linear_Searching;

public class LinearSearchExample2 {
    public static boolean searchChar(String str, char target) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String name = "Munna";
        char target = 'u';

        System.out.println(searchChar(name, target));  // true 
    }
}
