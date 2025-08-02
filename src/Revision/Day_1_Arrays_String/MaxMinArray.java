package Revision.Day_1_Arrays_String;

public class MaxMinArray {
    public static void main(String[] args) {
        int[] arr = {7, 2, 4, 9, 11, 45};
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("Maximum element is: " + max + ", Minimum element is: " + min);
    }
}

/*

Given an array arr[] of size n, find the maximum and minimum elements.
Logic:
Traverse the array once, compare and update max and min.
Dry Run:
For arr = [3, 1, 7, 2, 5]
Start: max = 3, min = 3
Compare 1 → min = 1
Compare 7 → max = 7
Compare 2 → no change
Compare 5 → no change

 */