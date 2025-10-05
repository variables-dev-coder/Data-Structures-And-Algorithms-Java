package Trees.Binary_Tree.Derived_Structures_Variants;

/*
Mirror / Invert a Binary Tree
Concept Recap
The mirror (or inverted) binary tree is formed by swapping left and right subtrees of all nodes.
For every node:

swap(node.left, node.right)

and recursively do the same for its children.
 */

class Node3 {
    int val;
    Node3 left, right;

    Node3(int val) {
        this.val = val;
    }
}

public class MirrorBinaryTree {

    // Recursive mirror function
    static Node3 mirror(Node3 root) {
        if (root == null)
            return null;

        // swap left and right
        Node3 temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recursively mirror children
        mirror(root.left);
        mirror(root.right);

        return root;
    }

    // Inorder traversal to verify mirror effect
    static void inorder(Node3 root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
        */
        Node3 root = new Node3(1);
        root.left = new Node3(2);
        root.right = new Node3(3);
        root.left.left = new Node3(4);
        root.left.right = new Node3(5);

        System.out.print("Original Inorder: ");
        inorder(root); // 4 2 5 1 3

        mirror(root);

        System.out.print("\nMirrored Inorder: ");
        inorder(root); // 3 1 5 2 4
    }
}

/*
Original Inorder: 4 2 5 1 3
Mirrored Inorder: 3 1 5 2 4

Dry Run
Original Tree:

        1
       / \
      2   3
     / \
    4   5
Step 1: Start from root 1, swap left (2) and right (3)

        1
       / \
      3   2
         / \
        4   5
Step 2: Move to node 3 (no children → no swap)
Step 3: Move to node 2, swap 4 and 5

        1
       / \
      3   2
         / \
        5   4
Final mirrored tree:

        1
       / \
      3   2
         / \
        5   4


Complexity
Time: O(n) → each node visited once
Space: O(h) → recursion stack height


 */