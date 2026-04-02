package revision3;

import java.util.*;

public class MaximumGap {

    public static int maximumGap(int[] nums) {

        if (nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int n = nums.length;
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = (max - min) / bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Fill buckets
        for (int num : nums) {
            int idx = (num - min) / bucketSize;

            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }

        int maxGap = 0;
        int prevMax = min;

        // Calculate max gap
        for (int i = 0; i < bucketCount; i++) {

            if (bucketMin[i] == Integer.MAX_VALUE) continue;

            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

    public static void main(String[] args) {

        int[] arr = {3,6,9,1};

        int result = maximumGap(arr);

        System.out.println("Maximum Gap: " + result);
    }
}
