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