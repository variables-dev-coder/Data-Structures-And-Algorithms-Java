package Arrays.Revesion_Sorting_Searching_Day02;

public class KthSmallestSelectionSort {
    public static void main(String[] args) {
        int[] arr = {7, 4, 6, 3, 9, 1};
        int k = 3;

        for (int i = 0; i < k; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        System.out.println(k + "th smallest: " + arr[k - 1]);
    }
}
