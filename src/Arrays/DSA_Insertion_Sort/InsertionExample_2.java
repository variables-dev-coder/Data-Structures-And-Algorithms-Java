package Arrays.DSA_Insertion_Sort;

public class InsertionExample_2 {
    public static void main(String[] args) {
        int[] arrays = {78, 23, 34, 17, 56, 12, 90, 3, 9, 7, 4, 8, 1, 0};
        int lowest = arrays.length;

        for (int i = 1; i < lowest; i++) {
            int insertIndex = i;
            int currentValue = arrays[i];
            int j = i - 1;

            while (j >= 0 && arrays[j] > currentValue) {
                arrays[j + 1] = arrays[j];
                insertIndex = j;
                j--;
            }
            arrays[insertIndex] = currentValue;
        }
        System.out.print("Sorted Array: ");
        for (int value : arrays) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
