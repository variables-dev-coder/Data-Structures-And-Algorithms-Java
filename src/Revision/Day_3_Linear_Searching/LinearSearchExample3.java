package Revision.Day_3_Linear_Searching;

public class LinearSearchExample3 {
    public static void searchOccurrence(int[] arr, int target) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.print(i + " ");
                found = true;
            }
        }
        if (!found)
            System.out.println("Not found");
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 7, 3, 9};
        int target = 3;

        searchOccurrence(arr, target);   // 0 2 4
    }
}
