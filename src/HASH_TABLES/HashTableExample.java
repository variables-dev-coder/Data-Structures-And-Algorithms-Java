package HASH_TABLES;

public class HashTableExample {
    public static void main(String[] args) {
        String value = "Bob";
        System.out.println("'" + value + "' has hash code: " + hashFunction(value));
    }
    public static int hashFunction(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += value.charAt(i);
        }
        return sum % 10;
    }
}
