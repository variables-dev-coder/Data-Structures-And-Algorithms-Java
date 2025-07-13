package Arrays.DSA_Bubble_Sort;

public class BubbleSort_2 {
    public static void main(String[] args) {
        int[] arr = {11, 14, 51, 0, 3, 9, 2, 1};
        int sort = arr.length;

        for (int i = 0; i < sort - 1; i++) {
            for (int j = 0; j < sort - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.print("Sorted Arrays: ");
        for (int i = 0; i < sort; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
