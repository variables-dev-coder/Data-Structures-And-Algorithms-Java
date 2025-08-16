package Arrays.Revision_Sorts;

public class SelectionSort_2 {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Assume the min is the first element
            int minIndex = i;

            // find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap the found minimum with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 56, 12, 34, 78, 10};

        selectionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// 10 12 23 34 56 78