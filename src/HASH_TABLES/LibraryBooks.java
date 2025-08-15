package HASH_TABLES;

import java.util.HashMap;
import java.util.Map;

public class LibraryBooks {
    public static void main(String[] args) {
        // Create a HashMap: bookTitle -> availableCopies
        Map<String, Integer> library = new HashMap<>();

        // 1. Add books to the library
        library.put("Harry Potter", 4);
        library.put("The Hobbit", 2);
        library.put("1984", 5);

        // 2. Borrow a book (reduce copies)
        String bookToBorrow = "Harry Potter";
        if (library.containsKey(bookToBorrow) && library.get(bookToBorrow) > 0) {
            library.put(bookToBorrow, library.get(bookToBorrow) - 1);
            System.out.println("Borrowed: " + bookToBorrow);
        } else {
            System.out.println(bookToBorrow + " is not available.");
        }

        // 3. Return a book (increase copies)
        String bookToReturn = "The Hobbit";
        if (library.containsKey(bookToReturn)) {
            library.put(bookToReturn, library.get(bookToReturn) + 1);
            System.out.println("Returned: " + bookToReturn);
        }

        // 4. Remove a book completely
        library.remove("1984");

        // 5. Display all books and their available copies
        System.out.println("\nLibrary Inventory:");
        for (Map.Entry<String, Integer> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " copies");
        }
    }
}
/*
Borrowed: Harry Potter
Returned: The Hobbit

Library Inventory:
Harry Potter -> 3 copies
The Hobbit -> 3 copies


Key idea

Keys = Book titles (String)
Values = Number of copies (Integer)
Uses hashing for fast book lookups and updates.

 */