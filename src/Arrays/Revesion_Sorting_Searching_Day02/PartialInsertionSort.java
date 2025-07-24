package Arrays.Revesion_Sorting_Searching_Day02;

public class PartialInsertionSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 5, 3, 1, 6, 8, 10};

        int mid = arr.length / 2;

        for (int i = 1; i < mid; i++) {
            int current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        for (int num : arr)
            System.out.print(num + " ");
    }
}
