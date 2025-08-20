package DSA_Hash_Sets;

//Performing Set Operations (Union, Intersection, Difference)
//Problem: Use HashSet to perform common set operations.

import java.util.HashSet;

public class HashSetExample5 {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        // Union (all unique elements)
        HashSet<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // Intersection (common elements)
        HashSet<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        // Difference (elements in set1 but not in set2)
        HashSet<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);
    }
}

/*
Union: [1, 2, 3, 4, 5, 6]
Intersection: [3, 4]
Difference (set1 - set2): [1, 2]

This is a very important real-time usage of HashSet in solving problems like finding common friends,
unique IDs, etc.

 */