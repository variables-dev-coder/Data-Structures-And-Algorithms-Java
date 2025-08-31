package Revision.Day_4_Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void findNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) stack.pop();
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(nge));
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        findNGE(arr); // [5, 10, 10, -1, -1]
    }
}
