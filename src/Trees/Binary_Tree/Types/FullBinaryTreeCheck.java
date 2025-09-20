package Trees.Binary_Tree.Types;

class Node2 {
    int val;
    Node2 left, right;

    Node2(int v) {
        val = v;
        left = right = null;
    }
}

public class FullBinaryTreeCheck {
    // Function to check Full Binary Tree
    static boolean isFull(Node root) {
        if (root == null) return true;

        // Leaf node → valid
        if (root.left == null && root.right == null) return true;

        // If both children exist → check subtrees
        if (root.left != null && root.right != null)
            return isFull(root.left) && isFull(root.right);

        // If only one child → not full
        return false;
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);

        System.out.println("Is Full Binary Tree? " + isFull(root)); // true
    }

}

// Is Full Binary Tree? true