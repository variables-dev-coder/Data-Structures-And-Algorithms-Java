package Arrays.DSA_Arrays;


// Given an integer array, find both the lowest value and its index position.
// using for loop

public class ArrayLowestValueIndex_1 {
    public static void main(String[] args) {
        int[] arrays = {9, 4, 6, 8, 1, 5, 11};
        int minVal = arrays[0];      // Step 1: Assume first element is min
        int minIndex = 0;            // Track index of min

        for (int i = 1; i < arrays.length; i++) {    // Step 2: Start loop from 1
            if (arrays[i] < minVal) {
                minVal = arrays[i];          // Update minimum value
                minIndex = i;                // Update minimum index
            }
        }
        System.out.println("Lowest Value: " + minVal);
        System.out.println("Index of Lowest value: " + minIndex);
    }
}
