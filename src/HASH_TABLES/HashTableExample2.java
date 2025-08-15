package HASH_TABLES;

public class HashTableExample2 {
    static final String[] myHashSet = {null, "Jones", null, "Lisa", null, "Bob", null, "Siri", "Pete", null};

    public static void main(String[] args) {
        System.out.println("'Pete' is in the Hash Set: " + contains("Pete"));
    }

    public static int hashFunction(String value) {
        int sumOfChars = 0;
        for (char c : value.toCharArray()) {
            sumOfChars += c;
        }
        return sumOfChars % 10;
    }

    public static boolean contains(String name) {
        int index = hashFunction(name);
        return myHashSet[index] != null && myHashSet[index].equals(name);
    }
}
