package Arrays.DSA_Arrays;

public class ArrayLowestValue_5 {
    public static void main(String[] args) {
        int[] ar = {90, 35, 12, 67, 89, 12, 56};
        int min = ar[0];     // Assume first element is the smallest

        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < min) {
                min = ar[i];
            }
        }
        System.out.println("the lowest value in the array: " + min);
    }
}
