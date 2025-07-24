package Arrays.Revesion_Sorting_Searching_Day02;

//  Count Total Swaps During Sorting

public class BubbleSortSwaps {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 5};
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Total Swaps: " + swaps);
    }
}
