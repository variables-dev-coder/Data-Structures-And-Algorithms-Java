package Arrays.DSA_Linear_Searc;


// Find the index of the element in the array. If not found, return -1.
// 1. Find an Element in an Array

public class LinearSearch_2 {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;   // element fount
            }
        }
        return -1;   // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        int target = 30;

        int result = linearSearch(arr, target);

        if (result != -1)   // or == target
            System.out.println("Element Found at index: " + result);
        else
            System.out.println("Element not Found!");
    }
}
