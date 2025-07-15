package Arrays.DSA_Insertion_Sort;

public class InsertionImproveExample_1 {
    public static void main(String[] args) {
        int[] array = {11, 19, 9, 8, 16, 0, 3, 15, 20};
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int insertIndex = i;
            int currentValue = array[i];
            int j = i - 1;

            while ( j >= 0 && array[j] > currentValue) {
                array[j +1] = array[j];
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
