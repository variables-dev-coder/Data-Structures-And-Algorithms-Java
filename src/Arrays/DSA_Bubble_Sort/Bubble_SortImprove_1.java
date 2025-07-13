package Arrays.DSA_Bubble_Sort;

// The Bubble Sort algorithm can be improved a little bit more.

// the array is almost sorted already, with the lowest numbers at the start, like this for example:

public class Bubble_SortImprove_1 {
    public static void main(String[] args) {
        int[] array = {7, 3, 9, 12, 11};
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
