package Trees.Binary_Tree.Types;


class Node3 {
    int val;
    Node3 left, right;
    Node3(int v) {
        val = v;
        left = right = null;
    }
}

public class PerfectBinaryTreeCheck {
    // Get depth (height) of leftmost path
    static int findDepth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    // Utility function to check perfect tree
    static boolean isPerfect(Node root, int depth, int level) {
        if (root == null) return true;

        // Leaf node: check if at same depth
        if (root.left == null && root.right == null)
            return (depth == level + 1);

        // If one child missing → not perfect
        if (root.left == null || root.right == null) return false;

        // Recur for both subtrees
        return isPerfect(root.left, depth, level + 1) &&
                isPerfect(root.right, depth, level + 1);
    }

    static boolean checkPerfect(Node root) {
        int d = findDepth(root);
        return isPerfect(root, d, 0);
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \ / \
          4  5 6  7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Is Perfect Binary Tree? " + checkPerfect(root)); // true
    }

}
