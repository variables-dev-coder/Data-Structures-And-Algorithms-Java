package revision8;

import java.util.*;

public class FindDuplicate {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 2};

        HashSet<Integer> set =
                new HashSet<>();

        for (int num : arr) {

            if (set.contains(num)) {

                System.out.println(
                        "Duplicate: " + num
                );

                return;
            }

            set.add(num);
        }
    }
}
