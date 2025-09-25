package Trees.Binary_Tree.Core_Operations;

public class Notes {
    public static void main(String[] args) {



        /*

Binary Tree – Core Operations Mastery
=====================================

1️⃣ Insert
==========
Unlike BST (ordered), a normal Binary Tree has no ordering, so we insert level-wise (BFS).
    Start from root, perform level-order traversal, and insert at the first available spot.
    Time Complexity: O(n) (worst case, all levels full).

Use-case: Building complete trees, heaps (array-based).


2️⃣ Delete
==========
In a Binary Tree (not BST), deletion is tricky:
    1.Find the node to delete.
    2.Find the deepest rightmost node.
    3.Replace target node with deepest node.
    4.Delete the deepest node.

Time Complexity: O(n).

In BST, deletion is structured (handle 0, 1, or 2 children cases).


3️⃣ Search / Find
=================
    Traverse tree (DFS or BFS) and compare values.
    Time Complexity: O(n).
    For BST → O(h) (better because of ordering).

Use-case: Check if value exists.


4️⃣ Height Calculation
======================
    Height = max depth from root to leaf.
    Formula:
        height(root) = 1 + max(height(root.left), height(root.right))

    Time Complexity: O(n).

Used in Balanced Tree checks, Diameter calculation, AVL rotations.


5️⃣ Count Nodes / Leaves
=======================
    Total Nodes = count recursively (left + right + 1).
    Leaf Nodes = nodes with no children.
    Time Complexity: O(n).

Useful for size, boundary traversal, leaf-path problems.


6️⃣ Mirror / Invert
==================
    Swap left and right children of every node recursively.
    Famous LeetCode #226 – Invert Binary Tree.

Time Complexity: O(n).

Practical use: Symmetry checks, problem-solving.



7️⃣ Serialize / Deserialize
==========================
    Serialization = store tree into array/string.
        Preorder + Null markers (#) OR
        Level-order with null markers.
    Deserialization = reconstruct tree from data.

Time Complexity: O(n).

Critical for network transfer, persistence, LeetCode problems.




✅ Key Insights
================
    Binary Tree ≠ BST → Insert/Delete are different.
    Search complexity → O(n) (tree), O(h) (BST).
    Height, Node Count, Mirror → simple recursion, must know.
    Serialize/Deserialize → interview favorite, tests recursion & data structure knowledge.



Binary Tree Core Operations – Interview Questions
=================================================

1. Insertion in Binary Tree
---------------------------
Q: How do you insert a new node in a Binary Tree (not BST)?
A: Use level-order traversal (BFS) with a queue. Insert the node at the first vacant left/right spot.


2. Deletion in Binary Tree
--------------------------
Q: How do you delete a node from a Binary Tree?
A: Find the deepest rightmost node, replace it with the node to be deleted, then delete the deepest node.


3. Search / Find
----------------
Q: How would you search for a node in a Binary Tree?
A: Use DFS (recursive) or BFS (queue-based). Unlike BST, there’s no order property, so you must traverse all nodes.


4. Height of Binary Tree
------------------------
Q: What is the time complexity of finding the height of a Binary Tree?
A: O(n), since you must check all nodes recursively.


5. Count Nodes and Leaves
-------------------------
Q: How do you count the total number of nodes in a Binary Tree?
A: Recursively: count = 1 + count(left) + count(right).
Leaves: if (node.left == null && node.right == null) return 1;


6. Mirror / Invert Tree
-----------------------
Q: How do you invert a Binary Tree?
A: Swap left and right child recursively for every node.
This is also a LeetCode favorite (#226 Invert Binary Tree).


7. Serialize / Deserialize
--------------------------
Q: How do you serialize and deserialize a Binary Tree?
A:
    Serialize → Use preorder with null markers (or BFS level-order).
    Deserialize → Rebuild tree using recursion (for preorder) or queue (for level-order).


8. Differences in Operations: Binary Tree vs. Binary Search Tree
----------------------------------------------------------------
Q: How do insertion, deletion, and search differ in a plain Binary Tree vs BST?
A:
    In Binary Tree: insert at first vacant place (not ordered).
    In BST: insert/delete/search based on ordering property.


9. Edge Cases
-------------
Q: What are edge cases for insertion and deletion in a Binary Tree?
A:
    Insertion: empty tree (new node becomes root).
    Deletion: deleting root when it’s the only node.


10. Applications
----------------
Q: What are real-life applications of serialize/deserialize of Binary Trees?
A:
    Saving trees in files (databases, JSON/XML).
    Sending trees across networks.
    Implementing undo/redo operations.



         */
    }
}
