package Revision.Day_1_Arrays_String;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = arr[0];
        int currSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}

// Maximum Subarray Sum: 6 ([4, -1, 2, 1])

/*

Problem:
Find the maximum sum of a contiguous subarray.
Logic:
Use running sum (currSum) and track max (maxSum).
Reset to 0 if currSum drops below 0.

 */