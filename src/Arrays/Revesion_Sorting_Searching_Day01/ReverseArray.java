package Arrays.Revesion_Sorting_Searching_Day01;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int i = 0;
        int j = arr.length - 1;

        System.out.print("Original Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();


        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.print("Reverse Array: ");
        for (int num : arr)
            System.out.print(num + " ");
    }
}
