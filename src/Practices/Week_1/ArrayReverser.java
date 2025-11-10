package Practices.Week_1;

import java.util.Arrays;

public class ArrayReverser {

    // Method to reverse Array

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // Method to reverse array in-place
    public static void reverseArrayInPlace(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(original));

        int[] reversed = reverseArray(original);
        System.out.println("Reversed: " + Arrays.toString(reversed));

        reverseArrayInPlace(original);
        System.out.println("Reversed in-place: " + Arrays.toString(original));
    }
}


//Original array: [1, 2, 3, 4, 5]
//Reversed: [4, 4, 4, 4, 4]
//Reversed in-place: [5, 4, 3, 2, 1]