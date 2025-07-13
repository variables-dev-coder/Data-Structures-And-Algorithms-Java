package Arrays.DSA_Bubble_Sort;

public class BubbleSort_4 {
    public static void main(String[] args) {
        int[] arrays = {9, 1, 0, 2, 4, 3, 5, 6, 7, 8};
        int sortArray = arrays.length;

        for (int i = 0; i < sortArray - 1; i++) {
            for (int j = 0; j < sortArray - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < sortArray; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }
}
