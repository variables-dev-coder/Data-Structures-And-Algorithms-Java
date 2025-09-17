package Trees.Binary_Tree.Properties;

public class Notes {
    public static void main(String[] args) {

        /*

Day 2 Target: Properties of a Binary Tree
=========================================

Properties to Know

1.Height
    Length of the longest path from root to a leaf.
    Height of empty tree = 0.
    Formula (recursive):
        height(root) = 1 + max(height(left), height(right))

2.Depth
    Distance of a node from the root.
    Root has depth 0.
    Each child node increases depth by +1.

3.Size
    Total number of nodes in the tree.
    Formula (recursive):
        size(root) = 1 + size(left) + size(right)

4.Leaf Nodes
    Nodes with no children.

5.Internal Nodes
    Nodes with at least one child (not a leaf).

===================================================



Java Implementation

package Trees.Binary_Tree.Properties;

class Node {
    int val;
    Node left, right;
    Node(int v) { val = v; }
}

public class BinaryTreeProperties {

    // Height of tree
    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Size of tree
    static int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    // Count leaf nodes
    static int countLeaves(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    // Count internal nodes
    static int countInternal(Node root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        return 1 + countInternal(root.left) + countInternal(root.right);
    }

    public static void main(String[] args) {
        // Build example tree
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Height: " + height(root));          // 3
        System.out.println("Size: " + size(root));              // 5
        System.out.println("Leaf Nodes: " + countLeaves(root)); // 3
        System.out.println("Internal Nodes: " + countInternal(root)); // 2
    }
}

Height: 3
Size: 5
Leaf Nodes: 3
Internal Nodes: 2


         */


    }
}
