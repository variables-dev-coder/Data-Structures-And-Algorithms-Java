package Arrays.DSA_Linear_Searc;

public class LinearSearch_4 {
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;  // increment if match found
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 6, 1, 3, 4, 5, 2, 2, 6, 4, 11};
        int target = 1;

        int result = countOccurrences(arr, target);

        System.out.println("Occurrence of " + target + " : " + result);
    }
}
