package Arrays.DSA_Counting_Sort;

public class countingSortMain_1 {
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
        for(int i = 0; i <= max_val; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3};
        countingSort(arr);

        System.out.print("Sorted Array: ");
        for (int num : arr){
            System.out.print(num + " ");
        }
            System.out.println();
    }
}
