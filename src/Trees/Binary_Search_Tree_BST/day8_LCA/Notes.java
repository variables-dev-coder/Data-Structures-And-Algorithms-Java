package Trees.Binary_Search_Tree_BST.day8_LCA;

public class Notes {
    public static void main(String[] args) {

        /*

Day 8 – Lowest Common Ancestor (LCA) in BST
===========================================


1. What is LCA (Lowest Common Ancestor)?
----------------------------------------

Given two nodes p and q,
LCA = the lowest (deepest) node in a tree that has both p and q as descendants.

A node can be its own ancestor.


2. Why is it easier in BST?
--------------------------
BST property:

Left subtree  = smaller values
Right subtree = larger values


So for LCA in BST:
    If both nodes < root → go left
    If both nodes > root → go right
    Otherwise → root is the LCA

This eliminates complex recursion used in Binary Trees.


3. LCA Rules (Very Important for Interviews)
--------------------------------------------
Case 1: Both p and q < root
    LCA must be in the left subtree

Case 2: Both p and q > root
    LCA must be in the right subtree

Case 3: p and q split at root
    This is the LCA
(One goes left, one goes right)

Case 4: Root matches one node
    Then root is the LCA



4. Master Intuition
-------------------
Imagine searching p and q as if they are in BST:
    Path to p
    Path to q
The last common node in both paths = LCA
But BST property lets us find it in O(log N) → no need to store paths.


5. Java Code
------------


class Node {
    int val;
    Node left, right;
    Node(int v) { val = v; }
}

public class BST_LCA {

    // Insert helper
    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    // LCA function (BST property)
    Node lowestCommonAncestor(Node root, int p, int q) {
        while (root != null) {
            if (p < root.val && q < root.val) {
                root = root.left; // go left
            } else if (p > root.val && q > root.val) {
                root = root.right; // go right
            } else {
                return root; // split → LCA found
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BST_LCA bst = new BST_LCA();
        Node root = null;

        int[] arr = {20, 10, 5, 15, 30, 25, 35};
        for (int x : arr) root = bst.insert(root, x);

        Node ans = bst.lowestCommonAncestor(root, 5, 15);
        System.out.println("LCA = " + ans.val);
    }
}


6. Dry Run with 3 Examples
Example 1

Tree:

        20
      /    \
     10     30
    /  \
   5   15


Find LCA(5, 15)

p=5, q=15

Both < 20 → go left

At 10 → p < 10 and q > 10 → split
LCA = 10


Example 2

Find LCA(25, 35)

p=25, q=35

Both > 20 → go right

At 30 → p < 30, q > 30 → split
LCA = 30


Example 3

Find LCA(10, 35)

10 < 20, 35 > 20 → split
LCA = 20

Final Goal Achieved

You understand what LCA means
You know why BST makes it easier
You know the exact rules
You can trace LCA for any pair
You can code iterative LCA in O(h)
You solved 3 dry-run examples


         */
    }
}
