package revision8;

import java.util.HashSet;

public class LongestConsecutive {

    static int longestConsecutive(int[] arr) {

        HashSet<Integer> set =
                new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // start of sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int length = 1;

                while (set.contains(currentNum + 1)) {

                    currentNum++;
                    length++;
                }

                longest = Math.max(
                        longest,
                        length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] arr = {
                100, 4, 200, 1, 3, 2
        };

        System.out.println(
                longestConsecutive(arr)
        );
    }
}
