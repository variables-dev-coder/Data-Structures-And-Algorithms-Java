package Arrays.DSA_Arrays;

// Given an integer array, find both the lowest value and its index position.
// Using for - each loop

public class ArrayLowestValueIndex_2 {
    public static void main(String[] args) {
        int[] arrays = {45, 23, 67, 12, 78};
        int minValue = arrays[0];
        int minIndex = 0;
        int index = 0;

        for (int i : arrays) {
            if (i < minValue) {
                minValue = i;
                minIndex = index;
            }
            index++;
        }
        System.out.println("Lowest Value: " + minValue);
        System.out.println("Lowest Value Index number: " + minIndex);
    }
}
