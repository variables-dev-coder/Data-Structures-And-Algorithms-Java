package DSA_Hash_Sets;

//Iterating over a HashSet
//Problem: Iterate through a HashSet using both for-each loop and Iterator.

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample4 {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        // Using for-each loop
        System.out.println("Using for-each loop:");
        for (int num : numbers) {
            System.out.println(num);
        }

        // Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

/*

Output (order may vary because HashSet is unordered):

Using for-each loop:
40
10
20
30

Using Iterator:
40
10
20
30

Notice that the order of elements is not guaranteed in a HashSet.

 */