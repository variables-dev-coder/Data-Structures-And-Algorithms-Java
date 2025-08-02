package Revision.Day_1_Arrays_String;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.print("Reversed Array: ");
        for (int num : arr)
            System.out.print(num + " ");
    }
}

/*
Problem:
Given an array, reverse its elements in place (without using extra array).
Logic:
Use 2-pointer technique → one from start, one from end.
Dry Run:
[1, 2, 3, 4, 5] → [5, 4, 3, 2, 1]

 */