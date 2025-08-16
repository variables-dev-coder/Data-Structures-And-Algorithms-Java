package Arrays.Revision_Sorts;

public class InsertionSort_2 {
    public static void insertionSort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i -1;

            // shift elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // place the key at its correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {22, 13, 56, 10, 4, 9, 11};

        insertionSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// 4 9 10 11 13 22 56