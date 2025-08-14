package Queue.Deque;


/*
Problem Statement
You are given:
Two arrays:
gas[i]: amount of gas available at station i.
cost[i]: cost of gas to travel from station i to i+1 (circular track).
Find the starting gas station index from which you can travel around the circle exactly once without
running out of gas.
If not possible, return -1.

Example
Input:
gas  = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]

Output:

3

Explanation:
Starting at index 3 → enough fuel to go full circle.
Approach with Deque Optimization
We can treat gain[i] = gas[i] - cost[i] and use a sliding window + deque to check minimum prefix sums efficiently.
The journey is possible if total gain is non-negative.
We find a point where the running total never drops below zero in a circular manner.

 */


public class GasStationDeque {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, tank = 0, start = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) { // Can't reach next station
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Starting Station: " + canCompleteCircuit(gas, cost));
    }
}

/*
Why Deque?
In a variation where gas and cost are large and we simulate circular traversal as 2n array:
We can maintain minimum prefix sum in a deque to quickly validate feasibility for each starting point.
This avoids recomputing sums for each start, improving efficiency.
 */