package Arrays.DSA_Arrays;

import java.util.Arrays;

// Java 8 Streams (advanced style):

public class MinUsingStreams_2 {
    public static void main(String[] args) {
        int[] arrays = {160, 34, 90, 23, 56, 12, 20, 1, 0};
        int lowest = Arrays.stream(arrays).min().getAsInt();
        System.out.println("Lowest value: " + lowest);
    }
}
