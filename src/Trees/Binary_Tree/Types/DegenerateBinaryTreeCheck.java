package Trees.Binary_Tree.Types;

//Check if a Binary Tree is Degenerate (Skewed)
//Condition:
//Every parent node has only one child.
//It behaves like a Linked List.
//Worst-case height = n

class Node6 {
    int val;
    Node6 left, right;

    Node6(int v) {
        val = v;
        left = right = null;
    }
}

public class DegenerateBinaryTreeCheck {
    // Check Degenerate Tree
    static boolean isDegenerate(Node6 root) {
        if (root == null) return true;

        // Leaf node
        if (root.left == null && root.right == null) return true;

        // If both children exist → not degenerate
        if (root.left != null && root.right != null) return false;

        // Move to the non-null child
        if (root.left != null)
            return isDegenerate(root.left);
        else
            return isDegenerate(root.right);
    }

    public static void main(String[] args) {
        /*
            Skewed (Right):
                1
                 \
                  2
                   \
                    3
        */
        Node6 root = new Node6(1);
        root.right = new Node6(2);
        root.right.right = new Node6(3);

        System.out.println("Is Degenerate Binary Tree? " + isDegenerate(root)); // true
    }
}

// Is Degenerate Binary Tree? true