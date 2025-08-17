package Arrays.Revision_Searching;

public class LinearSearchCount {
    public static int linearSearch(int[] arr, int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2, 2, 5, 2,1};
        int key = 2;

        int result = linearSearch(arr, key);
        System.out.println("The element " + key + " occurs " + result + " times.");
    }
}
