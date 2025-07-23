package Arrays.Revesion_Sorting_Searching_Day01;

public class BinarySearch {

    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return - 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 40;
        int result = binarySearch(arr, key);
        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
    }
}
