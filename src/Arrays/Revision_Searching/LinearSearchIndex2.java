package Arrays.Revision_Searching;

public class LinearSearchIndex2 {
    public static int linearSearch(int[] arr, int key) {
        for (int i = arr.length - 1; i >=0; i--) {
            if (arr[i] == key) {
                return i;   // return index of first occurrence
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 30, 40, 25, 50};
        int key = 25;

        int index = linearSearch(arr, key);

        if (index != -1) {
            System.out.println("Element " + key + " found at index " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}
