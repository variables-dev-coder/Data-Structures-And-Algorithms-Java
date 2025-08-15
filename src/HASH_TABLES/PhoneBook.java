package HASH_TABLES;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    public static void main(String[] args) {
        // Create a HashMap: name -> phone number
        Map<String, String> phoneBook = new HashMap<>();

        // 1. Add contacts
        phoneBook.put("Alice", "9876543210");
        phoneBook.put("Bob", "9123456780");
        phoneBook.put("Charlie", "9988776655");

        // 2. Retrieve a phone number
        System.out.println("Bob's number: " + phoneBook.get("Bob"));

        // 3. Update a phone number
        phoneBook.put("Alice", "9000000000");
        System.out.println("Updated Alice's number: " + phoneBook.get("Alice"));

        // 4. Check if a contact exists
        if (phoneBook.containsKey("Charlie")) {
            System.out.println("Charlie is in the phone book.");
        }

        // 5. Remove a contact
        phoneBook.remove("Bob");

        // 6. Display all contacts
        System.out.println("\nAll Contacts:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

/*
Bob's number: 9123456780
Updated Alice's number: 9000000000
Charlie is in the phone book.

All Contacts:
Alice -> 9000000000
Charlie -> 9988776655


Concept

Keys = Contact name (String)
Values = Phone number (String)
Hashing = Quick lookups by name in O(1) average time.

 */