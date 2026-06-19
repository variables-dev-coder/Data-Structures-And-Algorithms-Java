package revision11;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {

        int[] arr = {4,5,2,25};
        int n = arr.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {

            while(!stack.isEmpty()
                    && stack.peek() <= arr[i]) {

                stack.pop();
            }

            result[i] =
                    stack.isEmpty()
                            ? -1
                            : stack.peek();

            stack.push(arr[i]);
        }

        for(int x : result) {
            System.out.print(x + " ");
        }
    }
}
