package Arrays.Revision_Searching;

public class LinearSearchExample {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // return index where key is found
            }
        }
        return -1; // key not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 30, 45, 50};
        int key = 30;

        int result = linearSearch(arr, key);

        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
