package Practices.Week_3;

// NextGreaterElement

import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>(); // stores values
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,1,2,4,3};
        int[] ans = nextGreater(a);
        System.out.println(Arrays.toString(ans)); // [4,2,4,-1,-1]
    }
}
