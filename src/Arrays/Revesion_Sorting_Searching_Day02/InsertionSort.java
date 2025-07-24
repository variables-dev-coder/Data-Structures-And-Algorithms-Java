package Arrays.Revesion_Sorting_Searching_Day02;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {55, 67, 78, 12, 34, 22, 34, 10};

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;

            while ( j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        for (int num : arr)
            System.out.print(num + " ");
    }
}
