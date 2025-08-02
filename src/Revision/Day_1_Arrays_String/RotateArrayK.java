package Revision.Day_1_Arrays_String;

import java.util.Arrays;

public class RotateArrayK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        k %= arr.length; // handle k > n

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);

        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}

// Rotated Array: [5, 6, 7, 1, 2, 3, 4]

/*

Problem:
Rotate array to the right by k positions.
Logic:
Reverse whole array
Reverse first k elements
Reverse remaining elements

 */