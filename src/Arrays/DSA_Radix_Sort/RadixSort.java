package Arrays.DSA_Radix_Sort;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.print("Original Array: ");
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();

        int[][] radixArray = new int[10][array.length];
        int[] counts = new int[10];
        int maxVal = findMax(array);
        int exp = 1;

        while (maxVal / exp > 0) {
            for (int val : array) {
                int radixIndex = (val / exp) % 10;
                radixArray[radixIndex][counts[radixIndex]] = val;
                counts[radixIndex]++;
            }

            int pos = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    array[pos] = radixArray[i][j];
                    pos++;
                }
                counts[i] = 0;
            }
            exp *= 10;
        }
        System.out.println("Sorted Array: ");
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
}
