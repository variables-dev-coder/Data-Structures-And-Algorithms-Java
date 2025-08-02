package Revision.Day_1_Arrays_String;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {10, 20, 4, 45, 99};
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        System.out.println("Second Largest: " + second);
    }
}

/*

Problem:
Given an array, find the second largest element.

Logic:
Keep track of firstMax and secondMax.

 */