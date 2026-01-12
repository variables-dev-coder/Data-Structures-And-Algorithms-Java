package Arrays.revision;

public class MaxMinArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 9, 2};

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}

