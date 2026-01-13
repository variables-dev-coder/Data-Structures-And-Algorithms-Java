package DSA_Hash_Sets.revision;

import java.util.*;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        System.out.println(map);
    }
}

