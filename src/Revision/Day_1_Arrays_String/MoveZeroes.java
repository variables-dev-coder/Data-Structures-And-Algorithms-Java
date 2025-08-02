package Revision.Day_1_Arrays_String;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int index = 0; // points to where next non-zero should go

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }

        while (index < arr.length) {
            arr[index++] = 0;
        }

        for (int num : arr)
            System.out.print(num + " "); // 1 3 12 0 0

    }
}

/*
Given an array, move all 0s to the end without changing the order of non-zero elements.
Logic:
Use two pointers.
Move non-zero elements to the front.
Fill the rest with zeros.

 */