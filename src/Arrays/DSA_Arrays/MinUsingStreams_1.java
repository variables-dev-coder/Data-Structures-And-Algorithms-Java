package Arrays.DSA_Arrays;

import java.util.Arrays;

// use Java 8 Streams (advanced style):

public class MinUsingStreams_1 {
    public static void main(String[] args) {
        int[] numbers = {11, 23, 55, 78, 10, 9};
        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Lowest value: " + min);
    }
}
