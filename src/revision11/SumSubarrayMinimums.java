package revision11;

import java.util.Stack;

public class SumSubarrayMinimums {

    public static int sumSubarrayMins(int[] arr) {

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty()
                    && arr[stack.peek()] > arr[i]) {

                stack.pop();
            }

            left[i] =
                    stack.isEmpty()
                            ? i + 1
                            : i - stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Next Smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()
                    && arr[stack.peek()] >= arr[i]) {

                stack.pop();
            }

            right[i] =
                    stack.isEmpty()
                            ? n - i
                            : stack.peek() - i;

            stack.push(i);
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {

            answer +=
                    (long) arr[i]
                            * left[i]
                            * right[i];
        }

        return (int) answer;
    }

    public static void main(String[] args) {

        int[] arr = {3,1,2,4};

        System.out.println(
                sumSubarrayMins(arr)
        );
    }
}
