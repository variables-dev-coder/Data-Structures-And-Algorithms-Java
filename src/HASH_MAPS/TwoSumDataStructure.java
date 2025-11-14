package HASH_MAPS;

import java.util.*;

public class TwoSumDataStructure {
    /**
     * Problem: Design data structure that supports add and find operations for Two Sum
     * Concept: Use HashMap to store number frequencies
     * Time: O(1) for add, O(n) for find
     */
    static class TwoSum {
        private Map<Integer, Integer> numFreq;

        public TwoSum() {
            numFreq = new HashMap<>();
        }

        public void add(int number) {
            numFreq.put(number, numFreq.getOrDefault(number, 0) + 1);
        }

        public boolean find(int value) {
            for (int num : numFreq.keySet()) {
                int complement = value - num;
                int count = numFreq.getOrDefault(complement, 0);

                // Special case: if complement == num, we need at least 2 occurrences
                if (complement == num) {
                    if (count >= 2) {
                        return true;
                    }
                } else {
                    if (count >= 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        System.out.println("=== Two Sum Data Structure ===");
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);

        System.out.println("Find 4: " + twoSum.find(4)); // true (1 + 3)
        System.out.println("Find 7: " + twoSum.find(7)); // false
        System.out.println("Find 6: " + twoSum.find(6)); // true (1 + 5)

        System.out.println("Concept: Store frequencies to handle duplicate numbers");
        System.out.println();
    }
}

/*
=== Two Sum Data Structure ===
Find 4: true
Find 7: false
Find 6: true
Concept: Store frequencies to handle duplicate numbers

Two Sum III - Data Structure Design
Concept Used: Frequency Storage for Two Sum

Key Concept: Store number frequencies to handle cases where complement equals the number itself.
 */