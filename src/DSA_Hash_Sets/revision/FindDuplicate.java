package DSA_Hash_Sets.revision;

import java.util.*;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {
            if (!set.add(n)) {
                System.out.println(n);
                return;
            }
        }
    }
}

