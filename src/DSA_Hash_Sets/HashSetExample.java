package DSA_Hash_Sets;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // Add elements
        set.add("Apple");
        set.add("Banana");
        set.add("Mango");
        set.add("Apple"); // Duplicate ignored

        // Print set
        System.out.println("HashSet: " + set);

        // Check element
        System.out.println("Contains Mango? " + set.contains("Mango"));

        // Remove element
        set.remove("Banana");
        System.out.println("After removal: " + set);

        // Size
        System.out.println("Size: " + set.size());
    }
}

/*
HashSet: [Apple, Mango, Banana]
Contains Mango? true
After removal: [Apple, Mango]
Size: 2
Apple duplicate was ignored automatically.

Real-Time Use Cases
1. Remove duplicates from an array or list.
2. Fast membership checking:
    Check if an element exists in a collection.
3. Union, intersection, difference operations between sets.
4. Graph algorithms:
    Track visited nodes.

 */


/*
What is a Hash Set?

A Hash Set is a collection of unique elements. It is backed by a hash table internally (like HashMap in Java).

Key points:
No duplicates: Only unique elements are allowed.
Unordered: Elements are not stored in insertion order.
Fast operations: Add, remove, and contains operations are O(1) on average.
Null allowed: In Java, a HashSet can have one null element.

Think of it as a bag of unique items where you can quickly check whether an item exists or not.


How Hash Set Works Internally

1.HashSet uses a hash table internally.

2.When you add an element:
    It computes the hash code of the element.
    Maps it to an index in the underlying array (bucket).
    If the bucket is empty → element is added.
    If the bucket has elements → checks for equality. If duplicate → ignored; else → added.
3.Load factor & resizing: When the set reaches a threshold, it resizes for better performance.

Memory Flow Diagram (simplified):
HashSet
 ├─ Element 1 → hashcode → Bucket 0
 ├─ Element 2 → hashcode → Bucket 2
 └─ Element 3 → hashcode → Bucket 1

Buckets are arrays holding elements, linked via linked-list or tree (for collisions)


Basic Operations
| Operation          | Time Complexity | Description                         |
| ------------------ | --------------- | ----------------------------------- |
| add(E e)           | O(1) avg        | Adds element if not already present |
| remove(Object o)   | O(1) avg        | Removes element if present          |
| contains(Object o) | O(1) avg        | Checks if element exists            |
| size()             | O(1)            | Returns number of elements          |
| isEmpty()          | O(1)            | Checks if empty                     |


 */