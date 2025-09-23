package Trees.Binary_Tree.Binary_Tree_Traversals;

public class Notes {
    public static void main(String[] args) {

        /*

Traversal = visiting every node of a tree in a systematic way.
Two main categories:

1.Depth-First Traversals (DFS)
------------------------------
We go as deep as possible along one branch before backtracking.
Implemented using recursion (implicit stack) or explicit stack.


Preorder (Root → Left → Right)
    Visit root first, then left subtree, then right subtree.
    Used for copying a tree, prefix expression generation.

Inorder (Left → Root → Right)
    Visit left subtree, then root, then right subtree.
    In BST, inorder traversal gives sorted order.

Postorder (Left → Right → Root)
    Visit children first, then root.
    Used for deleting a tree, postfix expression evaluation.


2.Breadth-First Traversal (BFS / Level Order)
---------------------------------------------
    Visit nodes level by level using a queue.
    Useful for shortest path in an unweighted tree.
    Variants:
        Left-to-right
        Zigzag (spiral order)
        Level by level printing

3.Special Traversals
--------------------

Morris Traversal (O(1) space inorder)
-------------------------------------
    A clever algorithm that uses temporary links (threading) to traverse without stack/recursion.
    Time = O(n), Space = O(1).
    Great for memory-constrained environments.


Threaded Binary Tree
--------------------
    Special tree structure where null child pointers are replaced by pointers to inorder predecessor/successor.
    Purpose: To speed up inorder traversal and save stack/recursion.


Key Insights for Mastery
------------------------
    DFS → uses stack (implicit or explicit).
    BFS → uses queue.
    Morris → modifies tree temporarily, restores later.
    Threaded Trees → change structure permanently for efficient inorder traversal.
    Inorder of BST = sorted array → heavily used in interview questions.




========================================================================================

Q1. What are the different types of Binary Tree traversals?

A:
    1.Depth-First Traversals (DFS): Preorder, Inorder, Postorder
    2.Breadth-First Traversal (BFS / Level-order)
    3.Special Traversals: Morris Traversal, Threaded Binary Tree Traversal

---------------------------------------------------------------------------

Q2. What is the difference between DFS and BFS?

A:

| Feature        | DFS                           | BFS                             |
| -------------- | ----------------------------- | ------------------------------- |
| Order          | Go deep first                 | Go level by level               |
| Data structure | Stack (recursion/explicit)    | Queue                           |
| Use-case       | Path finding, tree operations | Shortest path, level processing |


--------------------------------------------------------------------------------------


Q3. When is Preorder traversal used?

A:
    Copying a tree
    Expression trees → generating prefix expressions
    Root processing before children


--------------------------------------------------------------------------------------


Q4. When is Inorder traversal important?

A:
    Produces sorted order for BSTs
    Useful in range queries, BST validation


--------------------------------------------------------------------------------------


Q5. When is Postorder traversal used?

A:
    Deleting a tree (children before root)
    Generating postfix expressions
    Useful for bottom-up calculations

---------------------------------------------------------------------------------------


Q6. What is Level-order traversal?

A:
    Traverses the tree level by level using a queue.
    Useful for printing tree level by level, BFS problems.


---------------------------------------------------------------------------------------


Q7. What is Morris Traversal and why is it used?

A:
    Inorder traversal without recursion or stack (O(1) space)
    Uses temporary links (threads) to inorder predecessor
    Time = O(n), Space = O(1)



--------------------------------------------------------------------------------------


Q8. What is a Threaded Binary Tree?

A:
    A tree where null pointers point to inorder predecessor/successor
    Purpose: To traverse inorder efficiently without stack/recursion


--------------------------------------------------------------------------------------



Q9. What is the time and space complexity of DFS and BFS?

A:
    DFS (recursive):
        Time: O(n)
        Space: O(h) → height of tree (stack)
    BFS (queue-based):
        Time: O(n)
        Space: O(w) → width of tree (max nodes in a level)



---------------------------------------------------------------------------------------

Q10. Which traversal is best for printing a BST in sorted order?

A:
    Inorder traversal (Left → Root → Right)


=========================================================================================



         */
    }
}
