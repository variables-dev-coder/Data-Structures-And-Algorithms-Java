package Arrays.DSA_Linear_Searc;

public class LinearSearchExample {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;   // Target found at index
            }
        }
        return -1;  // target not found
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6, 7, 8, 9, 12};
        int target = 1;

        int result = linearSearch(arr, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
}
