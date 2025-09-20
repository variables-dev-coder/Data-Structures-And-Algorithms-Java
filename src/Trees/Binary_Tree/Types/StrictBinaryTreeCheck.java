package Trees.Binary_Tree.Types;

//Check if a Binary Tree is Strict
//Condition:
//Each node must have either 0 or 2 children.
//Note: This is the same as Full Binary Tree.
//So, the logic is exactly the same as we already did in Full Binary Tree check.


class Node7 {
    int val;
    Node7 left, right;

    Node7(int v) {
        val = v;
        left = right = null;
    }
}

public class StrictBinaryTreeCheck {
    // Strict Binary Tree check (same as Full Binary Tree)
    static boolean isStrict(Node7 root) {
        if (root == null) return true;

        // Leaf node
        if (root.left == null && root.right == null) return true;

        // If both children exist → check recursively
        if (root.left != null && root.right != null)
            return isStrict(root.left) && isStrict(root.right);

        // If only one child exists → not strict
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
        Node7 root = new Node7(1);
        root.left = new Node7(2);
        root.right = new Node7(3);
        root.left.left = new Node7(4);
        root.left.right = new Node7(5);

        System.out.println("Is Strict Binary Tree? " + isStrict(root)); // true
    }
}

// Is Strict Binary Tree? true