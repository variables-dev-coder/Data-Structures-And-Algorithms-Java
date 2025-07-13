package Arrays.DSA_Bubble_Sort;

public class BubbleSort_1 {
    public static void main(String[] args) {
        int[] arrays = {64, 12, 33, 3, 78, 90, 10, 5, 1};
        int n = arrays.length;

        for (int i = 0; i < n - i; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }
}
