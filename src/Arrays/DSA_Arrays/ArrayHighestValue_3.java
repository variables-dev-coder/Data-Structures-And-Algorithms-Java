package Arrays.DSA_Arrays;

// Java program that finds only the highest (maximum) value in an array using a for-each loop:

public class ArrayHighestValue_3 {
    public static void main(String[] args) {
        int[] arrays = {89, 34, 67, 78, 12, 45, 23, 11};
        int maxValue = arrays[0];    // Assume first value is the highest

        for (int value : arrays) {
            if (value > maxValue) {
                maxValue = value;       // Update if a higher value is found
            }
        }
        System.out.println("Maximum value : " +maxValue);
    }
}
