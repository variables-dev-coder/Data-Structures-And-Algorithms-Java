package Revision.Day_2_Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetsExample {
    public static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Explore further subsets
        for (int i = index; i < nums.length; i++) {
            // Include this example
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            // Backtrack: remove last added element
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);

        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}


/*

[]
[1]
[1, 2]
[1, 2, 3]
[1, 2, 3, 4]
[1, 2, 4]
[1, 3]
[1, 3, 4]
[1, 4]
[2]
[2, 3]
[2, 3, 4]
[2, 4]
[3]
[3, 4]
[4]

 */