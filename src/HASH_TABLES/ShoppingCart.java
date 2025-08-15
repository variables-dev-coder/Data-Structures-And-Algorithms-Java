package HASH_TABLES;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    public static void main(String[] args) {
        // Create a HashMap: itemName -> quantity
        Map<String, Integer> cart = new HashMap<>();

        // 1. Add items to the cart
        cart.put("Apple", 3);
        cart.put("Banana", 5);
        cart.put("Milk", 2);

        // 2. Update quantity (adding more apples)
        cart.put("Apple", cart.get("Apple") + 2); // now 5 apples

        // 3. Check if item exists
        if (cart.containsKey("Milk")) {
            System.out.println("Milk is in the cart.");
        }

        // 4. Remove an item
        cart.remove("Banana");

        // 5. Display cart contents
        System.out.println("Shopping Cart:");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}


/*
Milk is in the cart.
Shopping Cart:
Apple -> 5
Milk -> 2


Why this works well with a HashMap
Keys = Item names (String)
Values = Quantities (Integer)
Hashing → Direct and fast access to each item by name in O(1) time.


 */