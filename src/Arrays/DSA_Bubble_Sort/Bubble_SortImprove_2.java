package Arrays.DSA_Bubble_Sort;

public class Bubble_SortImprove_2 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 0, 11, 2, 1};
        int sort = arr.length;

        for (int i = 0; i < sort - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < sort - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < sort; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
