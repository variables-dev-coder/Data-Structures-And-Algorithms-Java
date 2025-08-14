package Queue.Deque;

/*
Problem Statement

Given the price of stocks for n days,
Stock Span for a day is the number of consecutive days before it (including the current day) where the stock price was less than or equal to the current price.
Use a Deque to solve efficiently in O(n).

Example
Input:
prices = [100, 80, 60, 70, 60, 75, 85]

Output:
[1, 1, 1, 2, 1, 4, 6]

Approach
Use a Deque (or stack-like behavior) to store indices of prices in decreasing order.
For each price:
Remove elements from the back while the current price is greater or equal.
If deque is empty → span = i+1, else span = i - index of last greater price.
Push current index to deque.
 */


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class StockSpanDeque {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Deque<Integer> dq = new LinkedList<>(); // store indices

        for (int i = 0; i < n; i++) {
            // Remove smaller or equal prices from back
            while (!dq.isEmpty() && prices[dq.peekLast()] <= prices[i]) {
                dq.pollLast();
            }

            // If empty, all previous prices are smaller
            if (dq.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - dq.peekLast();
            }

            // Add current index
            dq.offerLast(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = calculateSpan(prices);
        System.out.println(Arrays.toString(result));
    }
}

/*
Dry Run

Prices: [100, 80, 60, 70, 60, 75, 85]

Day 0: span=1
Day 1: span=1
Day 2: span=1
Day 3: span=2
Day 4: span=1
Day 5: span=4
Day 6: span=6

 */