package Arrays.DSA_Linear_Searc;


// Find Minimum and Maximum in an Array using Linear Search
// Given an array of integers, find the smallest and largest element using one linear scan.


public class LinearSearch_7 {
    public static void findMinMax(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Minimun element: " + min);
        System.out.println("Maximum element: " + max);
    }

    public static void main(String[] args) {
        int[] arr = {11, 3, 29, 30, 8, 9};
        findMinMax(arr);
    }
}
