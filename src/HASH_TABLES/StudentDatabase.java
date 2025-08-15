package HASH_TABLES;

import java.util.HashMap;
import java.util.Map;

public class StudentDatabase {
    public static void main(String[] args) {
        // Create a HashMap: rollNumber -> studentName
        Map<Integer, String> students = new HashMap<>();

        // 1. Add students
        students.put(101, "Alice");
        students.put(102, "Bob");
        students.put(103, "Charlie");
        students.put(104, "David");

        // 2. Retrieve student name by roll number
        System.out.println("Student with roll 102: " + students.get(102));

        // 3. Update a student name
        students.put(103, "Chris"); // Charlie changed to Chris
        System.out.println("Updated student list: " + students);

        // 4. Remove a student
        students.remove(104);
        System.out.println("After removal: " + students);

        // 5. Iterate over entries
        System.out.println("\nAll Students:");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Roll: " + entry.getKey() + " -> Name: " + entry.getValue());
        }
    }
}

/*
Student with roll 102: Bob
Updated student list: {101=Alice, 102=Bob, 103=Chris, 104=David}
After removal: {101=Alice, 102=Bob, 103=Chris}

All Students:
Roll: 101 -> Name: Alice
Roll: 102 -> Name: Bob
Roll: 103 -> Name: Chris

Key points in this example
Keys = Roll numbers (Integer)
Values = Names (String)
Hashing is used internally to map roll numbers → array buckets.
Fast lookup by roll number.

 */