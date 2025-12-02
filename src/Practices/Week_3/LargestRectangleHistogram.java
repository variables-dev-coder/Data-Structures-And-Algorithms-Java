package Practices.Week_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!st.isEmpty() && h < heights[st.peek()]) {
                int height = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                max = Math.max(max, height * width);
            }
            st.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] h = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(h)); // 10
    }
}
