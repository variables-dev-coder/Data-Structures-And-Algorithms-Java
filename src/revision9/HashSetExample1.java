package revision9;

import java.util.HashSet;

public class HashSetExample1 {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();

        set.add("Java");
        set.add("Spring");
        set.add("Java"); // Duplicate

        System.out.println(set);
    }
}
