package Practices.Week_4;

/*
Stack Problem
--------------
Next Greater Element (NGE)

(One of the MOST asked stack questions — Amazon, Google, Microsoft)

Given an array, find for every element the Next Greater Element to its right.

If no greater element exists → return -1.

Example

arr = [4, 5, 2, 25]
Output = [5, 25, 25, -1]

Algorithm (Using Stack — O(n))
------------------------------
We use a stack to store indices of elements whose NGE is not found yet.

1.Create empty stack
2.Traverse array from right to left
3.For each element:
    Pop elements from stack ≤ current element
    If stack empty → NGE = -1
    Else → NGE = stack top
    Push current element to stack

Time Complexity

O(n) — Each element pushed & popped at most once.
O(n) space for stack + output

 */


import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        int[] ans = nextGreater(arr);

        System.out.println("Next Greater Elements:");
        System.out.println(Arrays.toString(ans));
    }
}

//Next Greater Elements:
//[5, 25, 25, -1]

/*
Explanation (Dry Run)

Array: [4, 5, 2, 25]

Process from right:

i = 3 → 25

Stack empty → NGE = -1
Push 25 → stack = [25]

i = 2 → 2

Top > 2 → NGE = 25
Push 2 → stack = [25,2]

i = 1 → 5

Pop 2
Pop 25 (because 25 > 5? No → we stop at 25)
NGE = 25
Push 5 → stack = [25,5]

i = 0 → 4

Top = 5 → NGE = 5
Push 4 → [25,5,4]

Final = [5, 25, 25, -1]
 */