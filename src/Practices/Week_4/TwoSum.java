package Practices.Week_4;

import java.util.HashMap;

/*
Array
-----
Two Sum (Most asked on FAANG)

Given an array arr[] and a target sum, return indices of the two elements whose sum is equal to the target.

Algorithm

1.Create a HashMap to store value → index
2.Traverse array
3.For each element:
    Check if target - arr[i] exists in HashMap
    If yes → pair found
    Else store current value in HashMap
4.Return the result

Time: O(n)
Space: O(n)
 */


public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

//Indices: 0, 1

/*

Explanation
arr = [2,7,11,15], target = 9
i = 0 → value = 2 → map = {2:0}
i = 1 → value = 7 → need = 2 → already in map
Pair found → indices = [0,1]

 */