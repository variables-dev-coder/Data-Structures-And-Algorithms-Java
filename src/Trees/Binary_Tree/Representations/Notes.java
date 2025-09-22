package Trees.Binary_Tree.Representations;

public class Notes {
    public static void main(String[] args) {

        /*

Day 4: Representations
----------------------
There are two main ways to represent a Binary Tree:
    1.Linked Node Representation (Node objects, pointers/links)
    2.Array Representation (heap-like indexing)


1. Linked Node Representation
-----------------------------
Most common representation in practice.
Each node contains:
    data (value)
    left pointer/reference (to left child)
    right pointer/reference (to right child)

Example in Java:


class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class LinkedNodeTree {
    public static void main(String[] args) {
        // Building tree:
        //      1
        //     / \
        //    2   3
        //   /
        //  4

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Root value: " + root.val);       // 1
        System.out.println("Left child of 1: " + root.left.val); // 2
        System.out.println("Right child of 1: " + root.right.val); // 3
    }
}

Flexible structure (good for dynamic insertion/deletion).
Extra memory (pointers), not cache-friendly.



2. Array Representation (Heap-like Indexing)
--------------------------------------------
Very useful in Heaps & Complete Binary Trees.
Rule: If node is at index i (0-based):
    Left child → 2i + 1
    Right child → 2i + 2
    Parent → (i - 1) / 2

Example:

Tree:
        1
       / \
      2   3
     / \
    4   5

Array Representation → [1, 2, 3, 4, 5]
    Index 0 → 1 (root)
    Index 1 → 2 (left of 1)
    Index 2 → 3 (right of 1)
    Index 3 → 4 (left of 2)
    Index 4 → 5 (right of 2)


public class ArrayTree {
    int[] tree;

    ArrayTree(int size) {
        tree = new int[size];
    }

    void setRoot(int val) {
        tree[0] = val;
    }

    void setLeft(int parentIndex, int val) {
        int leftIndex = 2 * parentIndex + 1;
        if (leftIndex < tree.length)
            tree[leftIndex] = val;
    }

    void setRight(int parentIndex, int val) {
        int rightIndex = 2 * parentIndex + 2;
        if (rightIndex < tree.length)
            tree[rightIndex] = val;
    }

    void printTree() {
        for (int val : tree) {
            if (val != 0) System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayTree t = new ArrayTree(10);
        t.setRoot(1);
        t.setLeft(0, 2);
        t.setRight(0, 3);
        t.setLeft(1, 4);
        t.setRight(1, 5);

        // Expected: 1 2 3 4 5
        t.printTree();
    }
}


Comparison: Linked vs Array Representation

| Feature         | Linked Nodes                        | Array Representation          |
| --------------- | ----------------------------------- | ----------------------------- |
| **Memory**      | Extra space for pointers            | Compact if tree is complete   |
| **Flexibility** | Good for dynamic operations         | Best for fixed complete trees |
| **Usage**       | General-purpose trees               | Heaps, Priority Queues        |
| **Traversal**   | Recursive or iterative via pointers | Index arithmetic              |





         */
    }
}
