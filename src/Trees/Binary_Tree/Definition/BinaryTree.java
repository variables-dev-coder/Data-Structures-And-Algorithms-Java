package Trees.Binary_Tree.Definition;



// BinaryTree.java
class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class BinaryTree {
    // recursive preorder: root, left, right
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // recursive inorder left -> root -> right
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        preorder(root.right);
    }

    // recursive postorder left -> right -> root
    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        inorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {

        // build a small tree:
        //      1
        //     / \
        //    2   3
        //   /
        //  4

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.print("Preorder: ");
        preorder(root);              // expected output: 1 2 4 3
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);               // Inorder: 4 2 1 3
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);            // Postorder: 4 2 3 1
        System.out.println();
    }
}

/*

Binary Tree Definition
-----------------------
A Binary Tree is a hierarchical data structure in which:
    Each node contains a value (data).
    Each node has at most two children:
        Left child
        Right child
    The topmost node is called the Root.
    Nodes with no children are called Leaves.


Key Terms
    Root → Starting node of the tree.
    Parent / Child → Relationship between connected nodes.
    Leaf → Node with no children.
    Internal Node → Node with at least one child.
    Height → Length of longest path from root to a leaf.
    Depth → Distance of a node from root.
    Size → Total number of nodes in the tree.

Small Visual Example
       1   ← Root
      / \
     2   3
    /
   4

Nodes = {1, 2, 3, 4}
Root = 1
Leaves = {4, 3}
Internal = {1, 2}
Height = 3 (levels: root → leaf)
Size = 4

Today’s takeaway:
Binary tree is a node-based hierarchical structure with at most 2 children.
Terminology is very important (Root, Leaf, Height, Depth, Size).
Code implementation starts from defining the Node class (we already have that).



Interview Questions (Basic - Definition Level)

1.What is a Binary Tree?
    Define it in 1–2 lines.
    Mention "each node has at most two children."

2.Difference between Binary Tree and Binary Search Tree (BST)?
    Binary Tree → No ordering rule, just structure.
    BST → Follows ordering property (left < root < right).

3.What is the difference between Full, Complete, and Perfect Binary Tree?
    Full → Each node has 0 or 2 children.
    Complete → All levels filled except possibly the last, filled left-to-right.
    Perfect → All internal nodes have 2 children and all leaves are at the same level.

4.Define Root, Leaf, Internal Node in a Binary Tree.
    Root → Topmost node.
    Leaf → No children.
    Internal → Has at least one child.

5.What is the maximum number of nodes at level l in a Binary Tree?
    Formula: 2^l (where level starts at 0 for root).

Bonus High-Level
    What is the maximum number of nodes in a Binary Tree of height h?
        Formula: 2^(h+1) - 1
        (if root is at height 0).

        
 */