package Trees.Binary_Tree.Types;

//Check if a Binary Tree is Balanced
//Condition:
//For every node, the height difference between left and right subtrees ≤ 1.
//Guarantees O(log n) height.
//Used in AVL Trees, Red-Black Trees.

class Node5 {
    int val;
    Node5 left, right;

    Node5(int v) {
        val = v;
        left = right = null;
    }
}

public class BalancedBinaryTreeCheck {
    // Returns height if balanced, -1 if not balanced
    static int checkHeight(Node5 root) {
        if (root == null) return 0;

        int lh = checkHeight(root.left);
        if (lh == -1) return -1; // left not balanced

        int rh = checkHeight(root.right);
        if (rh == -1) return -1; // right not balanced

        if (Math.abs(lh - rh) > 1) return -1; // current node not balanced

        return Math.max(lh, rh) + 1;
    }

    static boolean isBalanced(Node5 root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        Node5 root = new Node5(1);
        root.left = new Node5(2);
        root.right = new Node5(3);
        root.left.left = new Node5(4);
        root.left.right = new Node5(5);

        System.out.println("Is Balanced Binary Tree? " + isBalanced(root)); // true
    }

}

//Is Balanced Binary Tree? true