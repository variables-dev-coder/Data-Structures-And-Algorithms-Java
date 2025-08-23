package Revision.Day_3_Linear_Searching;

public class LinearSearchExample4 {
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];

        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 4, 1};
        System.out.println("Minimum element: " + findMin(arr));
    }
}
