package Arrays.DSA_Linear_Searc;


// 2. Check if Element Exists
// Check whether a target element exists in the array or not. Return true if found, else false.

public class LinearSearch_3 {
    public static boolean isElementPresent(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;    // Found target
            }
        }
        return false; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 9, 11, 45};
        int target = 10;

        boolean found = isElementPresent(arr, target);
        System.out.println("Is Target Present? " + found);
    }
}
