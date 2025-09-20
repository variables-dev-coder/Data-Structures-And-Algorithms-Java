package Trees.Binary_Tree.Types;

public class Notes {
    public static void main(String[] args) {

        /*

Binary Tree Types
=================

1️⃣ Full Binary Tree
--------------------
Definition: Every node has either 0 or 2 children (no node has only 1 child).
Properties:
    If there are n leaf nodes → number of internal nodes = n - 1.
    Not all levels need to be filled.

Example:

        1
       / \
      2   3
     / \
    4   5


2️⃣ Perfect Binary Tree
-----------------------
Definition: All internal nodes have 2 children and all leaves are at the same level.
Properties:
    Number of nodes = 2^h - 1 (where h = height).
    Number of leaves = 2^(h-1).

Example:
        1
       / \
      2   3
     / \ / \
    4  5 6  7


3️⃣ Complete Binary Tree
-----------------------
Definition: All levels are completely filled except possibly the last, which is filled from left to right.
Properties:
    Used in Heap data structure.
    Efficient for array representation.

Example:
        1
       / \
      2   3
     / \  /
    4  5 6


4️⃣ Balanced Binary Tree
-----------------------
Definition: For every node, the height difference between left & right subtree ≤ 1.
Properties:
    Ensures O(log n) height.
    Examples: AVL Tree, Red-Black Tree.

Example:
        1
       / \
      2   3
     / \
    4   5


5️⃣ Degenerate (Skewed) Binary Tree
-----------------------------------
Definition: Each parent has only one child → behaves like a linked list.
Properties:
    Height = n (worst case).
    Poor performance (O(n) operations).

Example (Right skewed):
    1
     \
      2
       \
        3


6️⃣ Strict Binary Tree
----------------------
Definition: Same as Full Binary Tree → nodes have either 0 or 2 children.
Often used interchangeably.


Interview Insights
------------------
Q: Difference between Full vs Perfect Binary Tree?
    → Full: every node has 0 or 2 children, not necessarily all levels filled.
    → Perfect: full + all leaves at the same depth.

Q: Why Heaps use Complete Binary Trees?
    → Easy array representation & guaranteed height = O(log n).

Q: Balanced vs Complete?
    → Balanced = height balanced (AVL, Red-Black).
    → Complete = filled left-to-right.




         */
    }
}
