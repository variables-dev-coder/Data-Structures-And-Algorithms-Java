package Arrays.DSA_Arrays;

// Given an array of integers, find the second smallest element.

public class SecondSmallest_2 {
    public static void main(String[] args) {
        int[] arrays = {90, 23, 56, 11, 44, 10, 78, 13, 9};

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arrays) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("No second smallest value (all are may be equal)");
        } else {
            System.out.println("Second Smallest Value: " + secondSmallest);
        }
    }
}
