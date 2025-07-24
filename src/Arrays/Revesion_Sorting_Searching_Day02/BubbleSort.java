package Arrays.Revesion_Sorting_Searching_Day02;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9, 7, 1, 6, 3, 2, 0, 8, 10};
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        for (int num : arr)
            System.out.print(num + " ");
    }
}
