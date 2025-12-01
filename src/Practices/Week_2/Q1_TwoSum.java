package Practices.Week_2;

import java.util.HashMap;

public class Q1_TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int need = target - arr[i];

            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}


// 0 1