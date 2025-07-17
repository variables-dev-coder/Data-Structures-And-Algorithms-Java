package Arrays.DSA_Counting_Sort;

public class countingSortMain_3 {
    public static void countingSort(int[] arr) {
        int max_val = arr[0];

        for (int num : arr) {
            if (num > max_val) {
                max_val = num;
            }
        }

        int[] count = new int[max_val + 1];

        for (int num : arr) {
            count[num]++;
        }

        int index = 0;

        for (int i = 0; i <= max_val; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 9, 9, 6, 6, 7, 8, 8, 0, 0, 0, 2, 2, 2, 3, 3, 3, 5, 5, 9, 6, 4, 3, 2};
        countingSort(arr);

        System.out.print("Sorting Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
