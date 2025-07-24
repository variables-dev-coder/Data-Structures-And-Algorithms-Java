package Arrays.Revesion_Sorting_Searching_Day02;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 23, 25, 99, 12, 10};

        for (int i = 0; i < arr.length -1; i++) {
            int minIdx = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[i];
                    arr[i] = temp;
                }
            }
            for (int num : arr)
                System.out.print(num + " ");
        }
    }
}
