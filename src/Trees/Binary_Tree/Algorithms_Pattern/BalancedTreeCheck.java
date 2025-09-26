package Trees.Binary_Tree.Algorithms_Pattern;

// Check Balanced Binary Tree (Divide & Conquer)

class Node3 {
    int val;
    Node3 left, right;

    Node3(int v) {
        val = v;
        left = right = null;
    }
}

public class BalancedTreeCheck {

    // Returns -1 if unbalanced, otherwise height
    static int checkBalance(Node3 root) {
        if (root == null) return 0;

        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) return -1; // left subtree unbalanced

        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) return -1; // right subtree unbalanced

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    static boolean isBalanced(Node3 root) {
        return checkBalance(root) != -1;
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        Node3 root1 = new Node3(1);
        root1.left = new Node3(2);
        root1.right = new Node3(3);
        root1.left.left = new Node3(4);
        root1.left.right = new Node3(5);

        System.out.println("Tree1 balanced? " + isBalanced(root1)); // true

        /*
              1
             /
            2
           /
          3
         /
        4
        */
        Node3 root2 = new Node3(1);
        root2.left = new Node3(2);
        root2.left.left = new Node3(3);
        root2.left.left.left = new Node3(4);

        System.out.println("Tree2 balanced? " + isBalanced(root2)); // false
    }
}

/*

Dry Run
Tree1 (Balanced):
        1
       / \
      2   3
     / \
    4   5


Node 4 → height 1

Node 5 → height 1

Node 2 → left=1, right=1 → height=2

Node 3 → height=1

Node 1 → left=2, right=1 → diff=1 → valid → height=3

Balanced

Tree2 (Unbalanced):
    1
   /
  2
 /
3
/
4


Node 4 → height 1

Node 3 → left=1, right=0 → height=2

Node 2 → left=2, right=0 → diff=2 (>1) → return -1

Whole tree fails balance check.
 Not Balanced

 Output
Tree1 balanced? true
Tree2 balanced? false
 */