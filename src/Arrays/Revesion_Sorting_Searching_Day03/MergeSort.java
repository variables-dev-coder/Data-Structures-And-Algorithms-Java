package Arrays.Revesion_Sorting_Searching_Day03;

public class MergeSort {

    public static void mergeSoft(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSoft(arr, left, mid);
            mergeSoft(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void main(String[] args) {

        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSoft(arr, 0, arr.length - 1);
        for (int val : arr)
            System.out.print(val + " ");
    }
}
