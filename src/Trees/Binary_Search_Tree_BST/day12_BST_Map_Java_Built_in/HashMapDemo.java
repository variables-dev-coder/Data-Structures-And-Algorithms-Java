package Trees.Binary_Search_Tree_BST.day12_BST_Map_Java_Built_in;

import java.util.HashMap;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(50, "A");
        map.put(30, "B");
        map.put(70, "C");

        System.out.println(map.get(30)); // B

        // No way to get next higher / range efficiently
        System.out.println(map); // Unordered
    }
}

//B
//{50=A, 70=C, 30=B}

/*
HashMap vs TreeMap — Code + Internals + When to Use What
This is pure interview gold

Core Difference (One-Line Clarity)

HashMap → fast access, no order

TreeMap → sorted access, BST-based (Red-Black Tree)

One is about speed, the other about structure + order

| Operation     | HashMap  | TreeMap  |
| ------------- | -------- | -------- |
| put()         | O(1) avg | O(log N) |
| get()         | O(1) avg | O(log N) |
| ordering      | ❌        | ✅        |
| range queries | ❌        | ✅        |
| floor / ceil  | ❌        | ✅        |

 */