package Trees.Binary_Tree.Day04_Balanced_Binary_Tree;

//Given a binary tree, determine if it is height-balanced.
//A binary tree is balanced if for every node, the difference between heights of left and right subtrees ≤ 1.

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}


public class BalancedTreeCheck {
    // Function to check height and balance in one traversal
    static int checkHeight(TreeNode root) {
        if (root == null) return 0;

        int left = checkHeight(root.left);
        if (left == -1) return -1; // Left subtree not balanced

        int right = checkHeight(root.right);
        if (right == -1) return -1; // Right subtree not balanced

        if (Math.abs(left - right) > 1) return -1; // Not balanced

        return 1 + Math.max(left, right); // Return height
    }

    static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        /*
                 10
               /   \
              5     20
             / \      \
            3   7      30
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(30);

        if (isBalanced(root))
            System.out.println("Tree is Balanced");
        else
            System.out.println("Tree is NOT Balanced");
    }
}

//Tree is Balanced

/*
Dry Run
Tree:
        10
       /  \
      5    20
     / \     \
    3   7     30
Start at leaf nodes:

height(3)=1

height(7)=1

height(30)=1

Node(5): left=1, right=1 → diff=0 → height=2

Node(20): left=0, right=1 → diff=1 → height=2

Node(10): left=2, right=2 → diff=0 → height=3

No node has diff > 1 → Tree is Balanced

Output: Tree is Balanced




If Unbalanced Tree

        10
       /
      5
     /
    3
Node(5): left=1 (node 3), right=0 → diff=1 → ok
Node(10): left=2, right=0 → diff=2
Immediately returns -1 → Not Balanced
Output: Tree is NOT Balanced



 */