package DSA_Hash_Sets;


// Check if an Element Exists
//Problem: Use HashSet to quickly check if a number exists in a dataset.


import java.util.HashSet;

public class HashSetExample2 {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Hyderabad");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");

        String search = "Delhi";

        if (cities.contains(search)) {
            System.out.println(search + " is present in the set.");
        } else {
            System.out.println(search + " is NOT present in the set.");
        }
    }
}

// Delhi is present in the set.

// HashSet.contains() uses hashing internally, so the search is O(1) average case, much faster than a loop.