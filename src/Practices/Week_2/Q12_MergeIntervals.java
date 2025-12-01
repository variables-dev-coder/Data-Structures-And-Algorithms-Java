package Practices.Week_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q12_MergeIntervals {
    public static int[][] merge(int[][] in) {
        Arrays.sort(in, (a, b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();

        int start = in[0][0], end = in[0][1];

        for (int i = 1; i < in.length; i++) {
            if (in[i][0] <= end) {
                end = Math.max(end, in[i][1]);
            } else {
                res.add(new int[]{start,end});
                start = in[i][0];
                end = in[i][1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        int[][] ans=merge(arr);
        for(int[] x:ans) System.out.println(x[0]+" "+x[1]);
    }
}
