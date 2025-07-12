package Arrays.DSA_Arrays;

// Given an array of integers, find the second smallest element.

public class SecondSmallest_1 {
    public static void main(String[] args) {
        int[] arr = {45, 23, 67, 12, 78};

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;  // update second first
                smallest = num;             // then update smallest
            } else if (num > smallest && num < secondSmallest) {
                secondSmallest = num;                               // update second smallest
            }
        }
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("No second smallest value (all values May be equal)");
        } else {
            System.out.println("Second Smallest Value: " + secondSmallest);
        }
    }
}
