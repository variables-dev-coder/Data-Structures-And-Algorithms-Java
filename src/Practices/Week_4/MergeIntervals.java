package Practices.Week_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Step 1: Sort by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        // Step 2: Merge
        for (int i = 1; i < intervals.length; i++) {
            int[] last = merged.get(merged.size() - 1);

            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }
}

//Merged Intervals:
//[1, 6]
//[8, 10]
//[15, 18]