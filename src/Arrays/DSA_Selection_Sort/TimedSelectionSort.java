package Arrays.DSA_Selection_Sort;

public class TimedSelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[10000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)(Math.random() * 100000);
        }

        long start = System.currentTimeMillis();
        selectionSort(nums);
        long end = System.currentTimeMillis();

        System.out.println("Sorted 10,000 random numbers in " + (end - start) + " ms");
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }
}
