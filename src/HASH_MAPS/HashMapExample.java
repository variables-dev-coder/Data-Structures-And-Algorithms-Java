package HASH_MAPS;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert
        map.put("Apple", 100);
        map.put("Banana", 200);
        map.put("Mango", 300);

        // Access
        System.out.println("Apple Price: " + map.get("Apple"));

        // Check Key
        System.out.println("Contains Mango? " + map.containsKey("Mango"));

        // Remove
        map.remove("Banana");

        // Iterate
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}

/*
Apple Price: 100
Contains Mango? true
Apple -> 100
Mango -> 300
 */

/*
1. What is a Hash Map in DSA?

A Hash Map (or Hash Table) is a data structure that stores key-value pairs for fast retrieval.
It uses a hashing function to map a key to an index in an array (called a bucket or slot).

Key → unique identifier
    Value → data stored
    Hash Function → converts key into array index
    Bucket → storage location (array index)

Example:
If we store ("apple", 100) in a HashMap:
hash("apple") = 3 → value stored at bucket 3.

2. Internal Working

Compute hash value of the key.
Map hash to an array index (using hash % arraySize).
Store (key, value) pair in that index (called a bucket).
If multiple keys map to the same index → Collision Handling.


3. Collision Handling

Two main techniques:
Chaining (Linked List/Tree at each bucket)
    Store multiple key-value pairs at the same index.
    Example: bucket[3] → (apple,100) → (mango,200)

Open Addressing
If a bucket is full, find another empty bucket (linear probing, quadratic probing, double hashing).

4. Operations and Complexity

| Operation | Average Case | Worst Case |
| --------- | ------------ | ---------- |
| Insert    | O(1)         | O(n)       |
| Search    | O(1)         | O(n)       |
| Delete    | O(1)         | O(n)       |



 */