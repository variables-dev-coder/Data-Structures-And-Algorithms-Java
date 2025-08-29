package Trees.Binary_Tree.Day01_Full_Binary_Tree;

/*
We’ll take this tree as an example:

        1
       / \
      2   3
     / \  / \
    4  5 6  7

This is a Full Binary Tree (every node has 0 or 2 children).
 */


class Node2 {
    int data;
    Node2 left, right;
    Node2(int data) {
        this.data = data;
        left = right = null;
    }
}


public class FullBinaryTree {
    static boolean isFullBinaryTree(Node2 node) {
        // empty tree
        if (node == null)
            return true;

        // leaf node
        if (node.left == null && node.right == null)
            return true;

        // node with 2 children → check recursively
        if (node.left != null && node.right != null)
            return (isFullBinaryTree(node.left) && isFullBinaryTree(node.right));

        // node with only 1 child → not full
        return false;
    }

    public static void main(String[] args) {
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);
        root.right.left = new Node2(6);
        root.right.right = new Node2(7);

        if (isFullBinaryTree(root))
            System.out.println("It is a Full Binary Tree");
        else
            System.out.println("Not a Full Binary Tree");
    }
}


/*
Dry Run

Step 1: isFullBinaryTree(root = 1)
    Node 1 has left (2) and right (3) → check both subtrees.
Step 2: isFullBinaryTree(node = 2)
    Node 2 has left (4) and right (5) → check both.
Step 3: isFullBinaryTree(node = 4)
    Node 4 has no children → leaf → return true.
Step 4: isFullBinaryTree(node = 5)
    Node 5 has no children → leaf → return true.

Subtree rooted at 2 returns true.

Step 5: isFullBinaryTree(node = 3)
    Node 3 has left (6) and right (7) → check both.
Step 6: isFullBinaryTree(node = 6)
    Node 6 has no children → leaf → return true.
Step 7: isFullBinaryTree(node = 7)
    Node 7 has no children → leaf → return true.

Subtree rooted at 3 returns true.

Step 8: Root node (1) → both left & right subtrees returned true.
Final result = true → Print:

If we remove one child, e.g., remove root.right.right = null, then node 3
will have only 1 child → function will return false.


 */