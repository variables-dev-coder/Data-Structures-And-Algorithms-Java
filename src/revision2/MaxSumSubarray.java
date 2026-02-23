package revision2;

import java.util.*;

public class MaxSumSubarray {

    public static int maxSumSubarray(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = 0;

        for(int i = 0; i < arr.length; i++) {
            windowSum += arr[i];

            if(i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[i - k + 1];
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;

        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + result);
    }
}
