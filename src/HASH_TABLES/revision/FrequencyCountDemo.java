package HASH_TABLES.revision;

import java.util.*;

public class FrequencyCountDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        System.out.println(freq);
    }
}

