package Revision.Day_6;

import java.util.*;

public class FrequencyCounter {

    public static Map<Integer, Integer> countFrequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};

        Map<Integer, Integer> freq = countFrequency(arr);

        for (int key : freq.keySet()) {
            System.out.println(key + " → " + freq.get(key) + " times");
        }
    }
}

//1 → 1 times
//2 → 2 times
//3 → 3 times