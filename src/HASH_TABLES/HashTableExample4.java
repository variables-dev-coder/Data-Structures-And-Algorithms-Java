package HASH_TABLES;

import java.util.HashMap;
import java.util.Map;

public class HashTableExample4 {
    public static void main(String[] args) {
        // Create a HashMap (Java's hash table)
        Map<String, Integer> marks = new HashMap<>();

        // 1. Inserting data
        marks.put("Alice", 85);
        marks.put("Bob", 92);
        marks.put("Charlie", 78);

        // 2. Retrieving a value
        System.out.println("Alice's marks: " + marks.get("Alice")); // 85

        // 3. Checking if a key exists
        if (marks.containsKey("Bob")) {
            System.out.println("Bob's marks: " + marks.get("Bob"));
        }

        // 4. Updating a value
        marks.put("Alice", 90); // replaces old value
        System.out.println("Alice's new marks: " + marks.get("Alice"));

        // 5. Iterating over entries
        System.out.println("\nAll Students:");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 6. Removing a key-value pair
        marks.remove("Charlie");
        System.out.println("\nAfter removing Charlie: " + marks);
    }
}

/*

Alice's marks: 85
Bob's marks: 92
Alice's new marks: 90

All Students:
Bob -> 92
Alice -> 90
Charlie -> 78


How this works internally
"Alice" → Java calculates hashCode() for "Alice".
That hash code is converted into a bucket index in the array.
The value 85 is stored in that bucket with "Alice" as the key.
On get("Alice"), the same steps happen to find the correct bucket quickly.
 */