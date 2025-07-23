package Arrays.Revesion_Sorting_Searching_Day01;

public class ReverseArray_1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.print("Original Array: ");
        for (int num : arr)
            System.out.print(num + " ");

        System.out.println();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        System.out.print("Reverse Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
