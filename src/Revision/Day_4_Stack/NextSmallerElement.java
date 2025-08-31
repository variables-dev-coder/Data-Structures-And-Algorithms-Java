package Revision.Day_4_Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Remove all greater or equal elements
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            // If stack empty → no smaller element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element into stack
            stack.push(arr[i]);
        }

        // Print result
        System.out.println("Next Smaller Elements:");
        System.out.println(Arrays.toString(result));
    }
}

//Next Smaller Elements:
//[2, 5, 2, -1, -1]