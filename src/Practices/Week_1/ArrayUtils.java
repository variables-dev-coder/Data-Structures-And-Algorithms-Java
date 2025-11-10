package Practices.Week_1;

import java.util.Arrays;

public class ArrayUtils {

    // Find second largest element
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found");
        }

        return second;
    }

    // Check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Rotate array by k positions
    public static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        if (k < 0) k += arr.length;

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] testArray = {5, 2, 8, 1, 9};

        System.out.println("Second largest: " + findSecondLargest(testArray));
        System.out.println("Is sorted: " + isSorted(testArray));

        int[] rotateArray = {1, 2, 3, 4, 5};
        System.out.println("Before rotation: " + Arrays.toString(rotateArray));
        rotateArray(rotateArray, 2);
        System.out.println("After rotation: " + Arrays.toString(rotateArray));
    }
}
