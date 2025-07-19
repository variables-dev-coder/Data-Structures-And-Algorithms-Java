package Arrays.DSA_Merge_Sort;


import java.util.Arrays;

public class MergeSortExample_1 {
    public static void main(String[] args) {
        double[] unsortedArr = {3, 7, 6, -10, 15, 23.5, 55, -13};
        double[] sortedArr = mergeSort(unsortedArr);
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
    }

    public static double[] mergeSort(double[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        double[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
        double[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);

        double[] sortedLeft = mergeSort(leftHalf);
        double[] sortedRight = mergeSort(rightHalf);

        return merge(sortedLeft, sortedRight);
    }

    public static double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
