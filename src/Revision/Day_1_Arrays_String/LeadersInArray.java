package Revision.Day_1_Arrays_String;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        int n = arr.length;
        int max = arr[n - 1];

        System.out.print("Leaders: " + max + " ");

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                System.out.print(max + " ");  // Leaders: 2 5 17 (in reverse order)
            }
        }
    }
}

/*

Leaders in an Array
Problem:
An element is a leader if it is greater than all the elements to its right.
Logic:
Traverse from right to left, keep track of maxSoFar.

 */
