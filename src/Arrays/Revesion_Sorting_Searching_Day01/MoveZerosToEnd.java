package Arrays.Revesion_Sorting_Searching_Day01;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 0, 3, 5};

        int index = 0;

        // shift all non-zero to the left
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        // fill remaining spaces with zero
        while (index < arr.length) {
            arr[index++] = 0;
        }

        // print result
        System.out.print("After moving zeros to end: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
