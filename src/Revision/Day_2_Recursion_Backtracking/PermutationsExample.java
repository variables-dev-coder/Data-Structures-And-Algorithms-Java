package Revision.Day_2_Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationsExample {
    public static void generatePermutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // skip already used numbers

            used[i] = true;
            current.add(nums[i]);

            generatePermutations(nums, used, current, result);

            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, new boolean[nums.length], new ArrayList<>(), result);

        System.out.println("All permutations:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}

/*
All permutations:
[1, 2, 3]
[1, 3, 2]
[2, 1, 3]
[2, 3, 1]
[3, 1, 2]
[3, 2, 1]
 */