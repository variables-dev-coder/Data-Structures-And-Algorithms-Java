package Revision.Day_3_Linear_Searching;

public class LinearSearchExample5 {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 4, 5, 11, 9, 12};
        System.out.println("Maximum element: " + findMax(arr));  // 12
    }
}
