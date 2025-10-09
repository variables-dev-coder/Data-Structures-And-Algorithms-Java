package Trees.Binary_Tree.Useful_Problems_Patterns;

/*
Zigzag Level Order Traversal (a.k.a Spiral Traversal)

Definition:
It’s a variation of level-order (BFS) traversal where the direction alternates with each level.

Level 1 → left to right

Level 2 → right to left

Level 3 → left to right
... and so on.

Example Tree
        1
       / \
      2   3
     / \   \
    4   5   6
Output:
[[1], [3, 2], [4, 5, 6]]

Approach

We’ll use Queue + Direction flag:
Perform normal level-order traversal.
Keep a boolean flag leftToRight to control the order.
Reverse current level when needed.

 */

import java.util.*;

class TreeNode5 {
    int val;
    TreeNode5 left, right;

    TreeNode5(int val) {
        this.val = val;
    }
}

public class ZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode5 root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode5> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode5 node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (!leftToRight)
                Collections.reverse(level);

            result.add(level);
            leftToRight = !leftToRight; // flip direction
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode5 root = new TreeNode5(1);
        root.left = new TreeNode5(2);
        root.right = new TreeNode5(3);
        root.left.left = new TreeNode5(4);
        root.left.right = new TreeNode5(5);
        root.right.right = new TreeNode5(6);

        ZigzagTraversal zz = new ZigzagTraversal();
        System.out.println(zz.zigzagLevelOrder(root));
    }
}

// [[1], [3, 2], [4, 5, 6]]

/*
Dry Run
Queue: [1] → output [1]
Direction: leftToRight = true

Queue: [2, 3] → output [3, 2]
Direction: flip → false

Queue: [4, 5, 6] → output [4, 5, 6]
Direction: flip → true

Final Output = [[1], [3, 2], [4, 5, 6]]


 */