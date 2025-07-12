package Arrays.DSA_Arrays;


// Java program that finds only the highest (maximum) value in an array using a for-each loop

public class ArrayHighestValue_1 {
    public static void main(String[] args) {
        int[] arrays = {45, 23, 67, 12, 46, 78};
        int maxvalue = arrays[0];    // Assume first value is the highest

        for (int value : arrays) {
            if (value > maxvalue) {
                maxvalue = value;    // Update if a higher value is found
            }
        }
        System.out.println("Highest Value: " +maxvalue);
    }
}
