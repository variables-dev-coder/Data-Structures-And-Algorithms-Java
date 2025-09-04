package Trees.Binary_Tree.Day03_Perfect_Binary_Tree;


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class PerfectBinaryTree {
    // Function to calculate depth (height) of tree
    static int findDepth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    // Function to check if tree is perfect
    static boolean isPerfect(Node root, int depth, int level) {
        if (root == null) return true;

        // If leaf node → depth must match
        if (root.left == null && root.right == null) {
            return (depth == level + 1);
        }

        // If internal node and missing a child → Not Perfect
        if (root.left == null || root.right == null) return false;

        // Recur for left and right subtree
        return isPerfect(root.left, depth, level + 1) &&
                isPerfect(root.right, depth, level + 1);
    }

    public static void main(String[] args) {

        // Example Perfect Binary Tree

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        int depth = findDepth(root);
        if (isPerfect(root, depth, 0))
            System.out.println("Tree is Perfect Binary Tree");
        else
            System.out.println("Tree is NOT Perfect Binary Tree");
    }
}

//Tree is Perfect Binary Tree

/*

Dry Run Example

        1
      /   \
     2     3
    / \   / \
   4  5  6   7

1.findDepth() → Leftmost path = 3 → depth = 3
2.isPerfect() checks:
    Node(1) → has both children → ok
    Node(2) & Node(3) → both have 2 children → ok
    Nodes (4,5,6,7) → leaves at level 3 → matches depth → ok

Output → Tree is Perfect Binary Tree



 */