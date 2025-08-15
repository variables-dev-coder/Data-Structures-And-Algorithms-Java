package HASH_TABLES;

import java.util.LinkedList;

public class HashTableExample3 {
    static LinkedList<String>[] myHashSet = new LinkedList[10];

    public static void main(String[] args) {
        for (int i = 0; i < myHashSet.length; i++) {
            myHashSet[i] = new LinkedList<>();
        }

        add("Jones");
        add("Lisa");
        add("Bob");
        add("Siri");
        add("Pete");
        add("Stuart");

        for (LinkedList<String> bucket : myHashSet) {
            System.out.println(bucket);
        }
        System.out.println("Contains Stuart: " + contains("Stuart"));
    }

    public static int hashFunction(String value) {
        int sum = 0;
        for (char c : value.toCharArray()) {
            sum += c;
        }
        return sum % 10;
    }

    public static void add(String value) {
        int index = hashFunction(value);
        LinkedList<String> bucket = myHashSet[index];
        if (!bucket.contains(value)) {
            bucket.add(value);
        }
    }

    public static boolean contains(String value) {
        int index = hashFunction(value);
        LinkedList<String> bucket = myHashSet[index];
        return bucket.contains(value);
    }
}
