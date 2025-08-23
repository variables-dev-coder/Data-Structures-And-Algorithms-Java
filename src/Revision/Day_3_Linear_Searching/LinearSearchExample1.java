package Revision.Day_3_Linear_Searching;

public class LinearSearchExample1 {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // return if found
            }
        }
        return -1; // if not found
    }


    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 9, 10};
        int target = 9;

        int index = linearSearch(arr, target);

        if (index != -1)
            System.out.println("Found at index: " + index);  // 3
        else
            System.out.println("Not found");
    }
}
