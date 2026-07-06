package revision13;

import java.util.HashSet;

public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        int longest = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {

                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100,4,200,1,3,2};

        System.out.println(
                longestConsecutive(nums)
        );
    }
}
