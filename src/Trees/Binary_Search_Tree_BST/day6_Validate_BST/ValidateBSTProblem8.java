package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*
Validate BST Using Inorder Traversal (NOT SORTED CASE)
Idea

For a valid BST:

 Inorder traversal must produce a strictly increasing sorted list.

If ANY value decreases, the tree is INVALID.

 Given Tree (NOT a BST)
          40
        /    \
      20      60
     / \     /  \
    10 25  50  30  ← WRONG (30 < 40, but placed in right subtree)

 Why invalid?

Right subtree of 40 has a node 30.

It is < 40 → cannot be in the right subtree.

In inorder, the output becomes unsorted.

 Inorder Traversal Output

Left → Root → Right:

10, 20, 25, 40, 50, 60, 30 ← Not sorted


Since this sequence is NOT strictly increasing → NOT A BST.

 */


import java.util.ArrayList;
import java.util.List;

public class ValidateBSTProblem8 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) { this.val = val; }
    }

    // Method 1: Inorder - check if sorted
    public static boolean isValidBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        // Check if strictly increasing
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1))
                return false;
        }
        return true;
    }

    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    public static void main(String[] args) {

        /*
                     40
                   /    \
                 20      60
                / \     /  \
              10  25   50  30 <-- WRONG (should be > 40)
        */

        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(25);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(30);  // invalid

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

// Is this tree a valid BST? false

/*
Dry Run (Master-Level)
Step 1 — Inorder Traversal Collection

Traverse left → root → right:

Sequence collected:

10  → 20 → 25 → 40 → 50 → 60 → 30

Step 2 — Check sorted order

Compare adjacent numbers:

20 > 10

25 > 20

40 > 25

50 > 40

60 > 50

 30 < 60 (DECREASE)

This violates the sorted property → Not a BST.

 */