package Trees.Binary_Tree.Complexity;


/*
Let’s now explore Iterative DFS (using Stack) vs Recursive DFS to highlight space complexity differences.
We’ll do Inorder Traversal (Left → Root → Right).
Iterative Inorder Traversal (Using Stack)

 */

import java.util.*;

class TreeNode4 {
    int val;
    TreeNode4 left, right;

    TreeNode4(int val) {
        this.val = val;
    }
}

public class IterativeInorder {
    public List<Integer> inorderTraversal(TreeNode4 root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode4> stack = new Stack<>();
        TreeNode4 curr = root;

        while (curr != null || !stack.isEmpty()) {
            // go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // process node
            curr = stack.pop();
            result.add(curr.val);

            // move to right subtree
            curr = curr.right;
        }

        return result;
    }

    public static void main(String[] args) {
        // Tree:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5

        TreeNode4 root = new TreeNode4(1);
        root.left = new TreeNode4(2);
        root.right = new TreeNode4(3);
        root.left.left = new TreeNode4(4);
        root.left.right = new TreeNode4(5);

        IterativeInorder sol = new IterativeInorder();
        System.out.println("Inorder Traversal (Iterative): " + sol.inorderTraversal(root));
        // Output: [4, 2, 5, 1, 3]
    }
}

// Inorder Traversal (Iterative): [4, 2, 5, 1, 3]

/*
Dry Run
Tree:
       1
     /   \
    2     3
   / \
  4   5

Steps:
    Push (1), go left → push (2), go left → push (4), left=null → pop (4).
    Pop (2), add → go right → push (5), left=null → pop (5).
    Pop (1), add → go right → push (3), left=null → pop (3).
Traversal = [4, 2, 5, 1, 3]


Complexity
    Time: O(n) (each node pushed & popped once)
    Space: O(h) for recursion stack in recursive version, but O(h) explicit stack in iterative version

Takeaway:
Recursive DFS → Space = O(h) (implicit call stack)
Iterative DFS → Space = O(h) (explicit stack)
Iterative avoids recursion overhead and stack overflow risk

 */