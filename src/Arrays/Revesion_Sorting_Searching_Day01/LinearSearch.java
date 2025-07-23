package Arrays.Revesion_Sorting_Searching_Day01;

public class LinearSearch {

    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
            return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 45, 23, 89, 56};
        int key = 89;
        int result = search(arr, key);
        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
    }
}
