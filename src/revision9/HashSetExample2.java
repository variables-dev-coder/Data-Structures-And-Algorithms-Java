package revision9;

import java.util.HashSet;

public class HashSetExample2 {
    public static void main(String[] args) {

        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers.contains(20));
        System.out.println(numbers.contains(50));
    }
}
