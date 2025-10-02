package Trees.Binary_Tree.Complexity;

public class Notes {
    public static void main(String[] args) {

        /*

Binary Tree Complexity
======================

1. Time Complexity
------------------
    Think about how many nodes you touch.

    Traversal (DFS or BFS)
        Each node is visited exactly once
        At each visit, you only do O(1) work (print, compare, add to list, etc.)
        Time = O(n), where n = number of nodes in the tree.

Examples:
    Preorder / Inorder / Postorder → O(n)
    BFS (level-order) → O(n)
    Finding Height → O(n)
    Checking Path Sum → O(n)

Even if recursion makes it look multiple times, every node is entered once → so still O(n).


-------------------------------------------------------------------------------------------


2. Space Complexity
-------------------
Two things contribute to space:
    Recursion stack (DFS)
    Queue/Stack (BFS)


a) Recursive DFS
    Max depth of recursion = height of tree (h)
    Best case (balanced tree): h = log(n)
    Worst case (skewed tree): h = n
    Space = O(h)

Examples:
Inorder/Preorder/Postorder recursion → O(h)


b) Iterative BFS (Queue)
    Queue holds nodes level by level
    Worst case: last level has about n/2 nodes (in a full binary tree)
    Space = O(n)

Example:
Level-order traversal (BFS) → O(n)


c) Iterative DFS (Stack)
    Stack may hold at most h nodes (like recursion).
    Space = O(h)


------------------------------------------------------------------------------------



3. Comparison Table
--------------------
| Operation         | Time | Space (Best) | Space (Worst) |
| ----------------- | ---- | ------------ | ------------- |
| DFS Recursive     | O(n) | O(log n)     | O(n)          |
| DFS Iterative     | O(n) | O(log n)     | O(n)          |
| BFS (Level-order) | O(n) | O(n)         | O(n)          |


--------------------------------------------------------------------------------------



4. Key Intuition
----------------
Time → How many nodes do you touch? → O(n).
Space → How many nodes do you store at once?
    DFS recursion → proportional to height h.
    BFS → proportional to width (up to n).


So final mastery summary:
-------------------------
    All traversals are O(n) time.
    DFS uses O(h) space.
    BFS uses O(n) space.



         */
    }
}
