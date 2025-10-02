package Trees.Binary_Tree.Complexity;

/*
Check if a Tree is Balanced (Divide & Conquer)
A binary tree is balanced if:
For every node, the difference between left and right subtree heights ≤ 1.
 */


class TreeNode6 {
    int val;
    TreeNode6 left, right;

    TreeNode6(int val) {
        this.val = val;
    }
}

public class BalancedTree {
    // Returns height if balanced, -1 if not
    private int checkHeight(TreeNode6 node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1; // not balanced

        int right = checkHeight(node.right);
        if (right == -1) return -1; // not balanced

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode6 root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        // Balanced Tree:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5

        TreeNode6 root = new TreeNode6(1);
        root.left = new TreeNode6(2);
        root.right = new TreeNode6(3);
        root.left.left = new TreeNode6(4);
        root.left.right = new TreeNode6(5);

        BalancedTree sol = new BalancedTree();
        System.out.println("Is Balanced? " + sol.isBalanced(root));
        // Output: true

        // Make it unbalanced: add one deeper node
        root.left.left.left = new TreeNode6(6);
        root.left.left.left.left = new TreeNode6(7);
        System.out.println("Is Balanced? " + sol.isBalanced(root));
        // Output: false
    }
}

/*
Is Balanced? true
Is Balanced? false

Dry Run
Balanced Case:
    1
   / \
  2   3
 / \
4   5

Node 4,5,3 → height 1
Node 2 → |1-1|=0 → height 2
Node 1 → |2-1|=1 → Balanced

Unbalanced Case:
                        1
   /
  2
 /
4
/
6
/
7

Left depth = 4, right = 0 → diff = 4 →  Not balanced

Complexity
Time: O(n) (each node visited once)
Space: O(h) recursion stack (height of tree)


Takeaway:
This is a classic divide & conquer:
Each recursive call returns a subtree property (height).
Combine results to determine balanced/unbalanced.


 */