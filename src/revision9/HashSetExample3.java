package revision9;

import java.util.HashSet;

public class HashSetExample3 {
    public static void main(String[] args) {

        HashSet<String> fruits = new HashSet<>();

        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        fruits.remove("Mango");

        System.out.println(fruits);
    }
}
