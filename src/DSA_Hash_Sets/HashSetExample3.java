package DSA_Hash_Sets;


// Remove Elements
//Problem: Remove an element from a HashSet and show the updated set.

import java.util.HashSet;

public class HashSetExample3 {
    public static void main(String[] args) {
        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("Original Set: " + fruits);

        // Remove element
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);

        // Try to remove an element not present
        boolean removed = fruits.remove("Grapes");
        System.out.println("Was Grapes removed? " + removed);
    }
}

/*
Original Set: [Apple, Banana, Mango, Orange]
After removing Banana: [Apple, Mango, Orange]
Was Grapes removed? false

HashSet.remove() returns true if the element was present and removed, otherwise false.
 */