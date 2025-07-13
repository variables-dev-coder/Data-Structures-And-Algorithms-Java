package Arrays.DSA_Bubble_Sort;

public class BubbleSort_3 {
    public static void main(String[] args) {
        int[] array = {9, 13, 56, 12, 34, 11, 9, 5, 2, 0,99};
        int sortArray = array.length;

        for (int i = 0; i < sortArray - 1; i++) {
            for (int j = 0; j < sortArray - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                 }
            }
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < sortArray; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
