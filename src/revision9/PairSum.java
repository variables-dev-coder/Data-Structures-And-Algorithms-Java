package revision9;

import java.sql.SQLOutput;
import java.util.HashSet;

public class PairSum {

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {

            int complement = target - num;

            if (set.contains(complement)) {
                System.out.println("Pair Found: " + complement + " + " + num);
                return;
            }

            set.add(num);
        }
        System.out.println("No Pair Found");
    }
}
