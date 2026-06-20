package revision11;

import java.util.*;

public class DailyTemperatures {

    public static int[] dailyTemperatures(
            int[] temperatures) {

        int n = temperatures.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i>=0; i--) {

            while(!stack.isEmpty() &&
                    temperatures[stack.peek()]
                            <= temperatures[i]) {

                stack.pop();
            }

            result[i] =
                    stack.isEmpty()
                            ? 0
                            : stack.peek() - i;

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr =
                {73,74,75,71,69,72,76,73};

        System.out.println(
                Arrays.toString(
                        dailyTemperatures(arr)
                )
        );
    }
}
