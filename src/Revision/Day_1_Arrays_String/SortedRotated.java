package Revision.Day_1_Arrays_String;

public class SortedRotated {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        int count = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }

        if (count == 1)
            System.out.println("Array is sorted and rotated");
        else
            System.out.println("Array is NOT sorted and rotated");
    }
}
