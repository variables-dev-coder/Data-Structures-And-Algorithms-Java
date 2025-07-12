package Arrays.DSA_Arrays;

public class ArrayLowestValue_4 {
    public static void main(String[] args) {
        int[] numbers = {45, 60, 23, 69, 90};

        int min = numbers[0];    // Assume first element is the smallest

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];  // Update min if a smaller value is found
            }
        }
        System.out.println("The lowest value in the array is : " + min);
    }
}
