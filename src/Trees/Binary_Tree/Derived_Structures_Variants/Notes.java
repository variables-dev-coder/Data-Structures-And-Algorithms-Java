package Trees.Binary_Tree.Derived_Structures_Variants;

public class Notes {
    public static void main(String[] args) {

        /*

1. Binary Search Tree (BST)
---------------------------
Concept:
    A BST is a Binary Tree where:

    Left subtree < Root < Right subtree

    Inorder traversal gives elements in sorted order.

Operations:

| Operation | Average  | Worst (skewed tree) |
| --------- | -------- | ------------------- |
| Insert    | O(log n) | O(n)                |
| Search    | O(log n) | O(n)                |
| Delete    | O(log n) | O(n)                |


Why BSTs matter:
    Used in implementing Set, Map, and database indexing.
    Foundation for AVL Trees, Red-Black Trees, and Treaps.



2.Heap (Max / Min Heap)
-----------------------
Concept:
    A Heap is a complete binary tree (filled left-to-right).
    Max-Heap: Parent ≥ children
    Min-Heap: Parent ≤ children
    Commonly implemented as an array, not via pointers.

Operations:

| Operation                | Time     |
| ------------------------ | -------- |
| Insert                   | O(log n) |
| Delete (extract max/min) | O(log n) |
| Peek (top)               | O(1)     |

Uses:
Priority Queue
Heap Sort
Dijkstra’s Algorithm


3.Threaded Binary Tree
----------------------
Concept:
    Optimized to make inorder traversal faster without recursion or stack.
    Empty left or right pointers are replaced by threads pointing to inorder predecessor or successor.

Advantage:
    Saves memory and avoids recursion.
    Especially useful for inorder traversal without stack.


4.Cartesian Tree / Treap
------------------------
Concept:
    A Cartesian Tree combines properties of BST and Heap:
        BST property on keys
        Heap property on priority
    Treap = Tree + Heap (randomized Cartesian Tree)

Uses:
    Randomized balanced search structure
    Expected O(log n) for operations
    Used in advanced data structures (like segment trees with random balancing)


Summary Table
--------------

| Variant           | Structure Type           | Key Property                 | Typical Usage          |
| ----------------- | ------------------------ | ---------------------------- | ---------------------- |
| **BST**           | Ordered Binary Tree      | Left < Root < Right          | Searching, sorting     |
| **Heap**          | Complete Binary Tree     | Max/Min at root              | Priority Queue         |
| **Threaded Tree** | Binary Tree with threads | Threaded traversal           | Fast Inorder Traversal |
| **Treap**         | Hybrid BST + Heap        | BST on key, Heap on priority | Randomized balancing   |



Mastery Tip:
Understanding these derived forms helps you transition into Tree-based Data Structures —
the backbone for Databases, OS Scheduling, and Competitive Programming.


         */
    }
}
