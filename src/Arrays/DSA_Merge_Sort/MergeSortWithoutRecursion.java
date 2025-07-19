package Arrays.DSA_Merge_Sort;

import java.util.Arrays;

public class MergeSortWithoutRecursion {

    public static double[] merge(double[] left, double[] right) {
        double[] result = new double[left.length + right.length];
        int i = 0;
        int j = 0;
        int k = 0;

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

    public static double[] mergeSort(double[] arr) {
        int step = 1;
        int length = arr.length;

        while (step < length) {
            for (int i = 0; i < length; i += 2 * step) {
                int mid = Math.min(i + step, length);
                int end = Math.min(i + 2 * step, length);

                double[] left = Arrays.copyOfRange(arr, i, mid);
                double[] right = Arrays.copyOfRange(arr, mid, end);

                double[] merged = merge(left, right);

                System.arraycopy(merged, 0, arr, i, merged.length);
            }
            step *= 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        double[] unsortedArr = {3, 7, 6, -10, 15, 23.5, 55, -13};
        double[] sortedArr = mergeSort(unsortedArr);

        System.out.println("Sorted Array: " + Arrays.toString(sortedArr));
    }

}
