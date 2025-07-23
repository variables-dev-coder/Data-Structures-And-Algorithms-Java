package Arrays.Revesion_Sorting_Searching_Day01;

public class LeftRotateArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        //Save the first element
        int temp = arr[0];

        //Shift elements to the left
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        // Place the first element at the end
        arr[arr.length - 1] = temp;

        //Print the rotated array
        System.out.print("Array after left rotation : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
