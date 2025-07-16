package Arrays.DSA_Quick_Sort;

import java.util.Stack;

public class QuickSortNonRecursive {
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) System.out.print(i + " ");
    }

    static void quickSort(int[] arr, int low, int high) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{low, high});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int l = range[0], h = range[1];

            if (l < h) {
                int pi = partition(arr, l, h);
                stack.push(new int[]{l, pi - 1});
                stack.push(new int[]{pi + 1, h});
            }
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
