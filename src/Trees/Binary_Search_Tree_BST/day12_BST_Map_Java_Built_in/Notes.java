package Trees.Binary_Search_Tree_BST.day12_BST_Map_Java_Built_in;

public class Notes {
    public static void main(String[] args) {

        /*

DSA Day 12 – BST + Map (Java Internals)
===========================================
TreeMap & TreeSet (Mastery Level)

1. Why This Topic Is IMPORTANT
------------------------------
Interviewers don’t ask “what is TreeMap” — they ask:
    -> Why TreeMap is ordered
    -> Why TreeMap operations are O(log N)
    -> Why HashMap can’t do range queries
    -> What tree is used internally

Answer: Red-Black Tree (self-balancing BST)

2. TreeMap & TreeSet – Big Picture
----------------------------------

| Feature        | TreeMap            | TreeSet        |
| -------------- | ------------------ | -------------- |
| Stores         | Key → Value        | Only Keys      |
| Ordering       | Sorted by key      | Sorted         |
| Duplicate keys |  No                |  No            |
| Null keys      |   No               |   No           |
| Internal DS    | **Red-Black Tree** | Red-Black Tree |
| Time           | O(log N)           | O(log N)       |

TreeSet = TreeMap where value is a dummy object


3. Red-Black Tree (What You MUST Know)
--------------------------------------
You do NOT need full implementation, but concepts are mandatory.

RB Tree Rules:
    Each node is RED or BLACK
    Root is always BLACK
    No two RED nodes in a row
    Every path has same number of BLACK nodes
    Ensures height ≈ log N

This guarantees balanced BST → fast search.


4. Core TreeMap Operations (With Meaning)
-----------------------------------------
put(key, value)
    Inserts key in sorted position
    Rebalances using rotations + recoloring

TreeMap<Integer, String> map = new TreeMap<>();
map.put(10, "A");
map.put(20, "B");
map.put(5, "C");

Order: 5 → 10 → 20


get(key)
--------
Standard BST search (log N)
    map.get(10); // "A"

higherKey(key)
--------------
Smallest key greater than given key
    map.higherKey(10); // 20

BST logic: go right, then left-most

lowerKey(key)
-------------
Largest key smaller than given key
    map.lowerKey(10); // 5

subMap(from, to)
----------------
Range view using inorder traversal
    map.subMap(5, 20); // {5=A, 10=B}

Impossible efficiently with HashMap

5. TreeMap Example
------------------

import java.util.*;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(50, "A");
        map.put(30, "B");
        map.put(70, "C");
        map.put(40, "D");

        System.out.println(map);               // Sorted
        System.out.println(map.get(30));       // B
        System.out.println(map.higherKey(40)); // 50
        System.out.println(map.lowerKey(40));  // 30
        System.out.println(map.subMap(30, 70));// {30=B, 40=D, 50=A}
    }
}


6. Custom TreeMap (BST-Based – Simplified)
------------------------------------------
Interview Insight
Java’s TreeMap uses Red-Black Tree,
but interviewers may ask you to implement a simple TreeMap using BST.

Minimal Custom TreeMap
----------------------

class Node {
    int key;
    String value;
    Node left, right;

    Node(int k, String v) {
        key = k;
        value = v;
    }
}

class MyTreeMap {

    Node root;

    void put(int key, String value) {
        root = insert(root, key, value);
    }

    Node insert(Node root, int key, String value) {
        if (root == null) return new Node(key, value);

        if (key < root.key)
            root.left = insert(root.left, key, value);
        else if (key > root.key)
            root.right = insert(root.right, key, value);
        else
            root.value = value;

        return root;
    }

    String get(int key) {
        Node curr = root;
        while (curr != null) {
            if (key < curr.key) curr = curr.left;
            else if (key > curr.key) curr = curr.right;
            else return curr.value;
        }
        return null;
    }
}


7. BST vs TreeMap (INTERVIEW GOLD)
----------------------------------

| Feature          | BST (Simple)     | TreeMap  |
| ---------------- | ---------------- | -------- |
| Balance          | ❌ Not guaranteed | ✅ Always |
| Worst Time       | O(N)             | O(log N) |
| Ordering         | Yes              | Yes      |
| Production Ready | ❌                | ✅        |
| Used in Java     | ❌                | ✅        |


TreeMap = Self-Balancing BST

Final Mastery Checklist (Day 12)
--------------------------------
Know TreeMap & TreeSet internals
Understand Red-Black Tree intuition
Use higherKey / lowerKey / subMap confidently
Explain why TreeMap ≠ HashMap
Implement simplified TreeMap via BST
Interview-ready explanations


         */
    }
}
