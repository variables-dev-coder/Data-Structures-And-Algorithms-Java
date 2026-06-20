package revision11;

import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {

        int[] price = {100,80,60,70,60,75,85};
        int n = price.length;

        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {

            while(!stack.isEmpty() &&
                    price[stack.peek()] <= price[i]) {

                stack.pop();
            }

            if(stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }

        for(int s : span) {
            System.out.print(s + " ");
        }
    }
}
