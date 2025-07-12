package Arrays.DSA_Arrays;

// Java program that finds only the highest (maximum) value in an array using a for-each loop:

public class ArrayHighestValue_2 {
    public static void main(String[] args) {
        int[] arr = {11, 6, 9, 112, 34, 67, 1};
        int maxValue = arr[0];      // Assume first value is the highest

        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;      // Update if a higher value is found
            }
        }
        System.out.println("Maximum Value is : " + maxValue);
    }
}
