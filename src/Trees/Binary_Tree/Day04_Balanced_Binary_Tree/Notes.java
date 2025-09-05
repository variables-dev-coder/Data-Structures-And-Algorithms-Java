package Trees.Binary_Tree.Day04_Balanced_Binary_Tree;

public class Notes {
    public static void main(String[] args) {

        /*

Balanced Binary Tree
---------------------

Concept (Simple Words)
A Balanced Binary Tree is a tree where the height difference between left
and right subtrees of any node is at most 1.

In other words:
    Left and right subtree heights can differ,
    But never more than 1.

This ensures the tree stays efficient (O(log n) height).


==============================


Why Important?
    Searching, insertion, deletion in Balanced Trees = O(log n).
    If unbalanced, tree can become like a linked list → O(n).
    Balanced trees are the base of AVL Tree, Red-Black Tree, B-Trees, etc.

Example 1: Balanced Tree

        10
       /  \
      5    20
     / \     \
    3   7     30

Node(10): left height=2, right height=2 → difference=0
Node(5): left=1, right=1 → diff=0
Node(20): left=0, right=1 → diff=1
This is Balanced


Example 2: NOT Balanced

        10
       /
      5
     /
    3

Node(10): left height=2, right=0 → difference=2
This is Unbalanced

Example

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BalancedBinaryTree {

    // Function to check height
    static int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Function to check if Balanced
    static boolean isBalanced(Node root) {
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        // Balanced Tree
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(30);

        if (isBalanced(root))
            System.out.println("Tree is Balanced");
        else
            System.out.println("Tree is NOT Balanced");
    }
}


Dry Run
Tree:
        10
       /  \
      5    20
     / \     \
    3   7     30

1. height(3)=1, height(7)=1 → Node(5)=2
2. height(30)=1, Node(20)=2
3. Node(10): left=2, right=2 → diff=0

All nodes satisfy balance condition →
Output: "Tree is Balanced"




         */


    }
}
