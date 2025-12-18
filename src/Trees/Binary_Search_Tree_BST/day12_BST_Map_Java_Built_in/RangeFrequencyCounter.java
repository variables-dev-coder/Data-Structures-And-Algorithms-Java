package Trees.Binary_Search_Tree_BST.day12_BST_Map_Java_Built_in;

import java.util.TreeMap;

public class RangeFrequencyCounter {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    // Add number
    void add(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    // Count numbers in range [L, R]
    int countInRange(int L, int R) {
        int count = 0;
        for (int freq : map.subMap(L, true, R, true).values()) {
            count += freq;
        }
        return count;
    }

    public static void main(String[] args) {
        RangeFrequencyCounter counter = new RangeFrequencyCounter();

        counter.add(10);
        counter.add(20);
        counter.add(20);
        counter.add(30);
        counter.add(40);

        System.out.println(counter.countInRange(15, 30)); // Output: 3
    }
}
