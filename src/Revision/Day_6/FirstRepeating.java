package Revision.Day_6;

import java.util.*;

public class FirstRepeating {

    public static int firstRepeating(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Find first element whose frequency > 1
        for (int num : arr) {
            if (freq.get(num) > 1) {
                return num;
            }
        }

        return -1; // No repeating element
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};

        System.out.println("First Repeating Element = " + firstRepeating(arr));
    }
}

// First Repeating Element = 5