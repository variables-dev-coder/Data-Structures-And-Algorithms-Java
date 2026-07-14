package revision14;

import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    stack.peek() <= nums[i]) {

                stack.pop();
            }

            result[i] = stack.isEmpty()
                    ? -1
                    : stack.peek();

            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4,5,2,25};

        System.out.println(Arrays.toString(nextGreaterElement(nums)));
    }
}
