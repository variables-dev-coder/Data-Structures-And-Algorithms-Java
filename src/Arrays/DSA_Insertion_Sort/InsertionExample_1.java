package Arrays.DSA_Insertion_Sort;

public class InsertionExample_1 {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 45, 11, 10, 90, 5};
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int insertIndex = i;
            int currentValue = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > currentValue) {
                array[j + 1] = array[j];
                insertIndex = j;
                j--;
            }
            array[insertIndex] = currentValue;
        }
        System.out.print("Sorted Array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
