package Arrays.DSA_Insertion_Sort;

public class InsertionExample_3 {
    public static void main(String[] args) {
        int[] arr = {9, 1, 8, 0, 7, 2, 5, 3, 6, 4, 10};
        int minimum = arr.length;

        for (int i = 1; i < minimum; i++) {
            int minIndex = i;
            int currentValue = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > currentValue) {
                arr[j + 1] = arr[j];
                minIndex = j;
                j--;
            }
            arr[minIndex] = currentValue;
        }
        System.out.print("Sorted Array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
