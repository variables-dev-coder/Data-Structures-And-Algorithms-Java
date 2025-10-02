package Trees.Binary_Tree.Complexity;

import java.util.*;

class TreeNode5 {
    int val;
    TreeNode5 left, right;

    TreeNode5(int val) {
        this.val = val;
    }
}

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode5 root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode5> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode5 node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
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

        TreeNode5 root = new TreeNode5(1);
        root.left = new TreeNode5(2);
        root.right = new TreeNode5(3);
        root.left.left = new TreeNode5(4);
        root.left.right = new TreeNode5(5);

        LevelOrderTraversal sol = new LevelOrderTraversal();
        System.out.println("Level Order Traversal: " + sol.levelOrder(root));
        // Output: [[1], [2, 3], [4, 5]]
    }
}

/*

Dry Run
Tree:

Steps:
Queue = [1] → pop → add level [1], push children [2,3]
Queue = [2,3] → pop → add level [2,3], push children [4,5]
Queue = [4,5] → pop → add level [4,5]
Result = [[1], [2, 3], [4, 5]]

Complexity
Time: O(n) (each node visited once)
Space: O(n) (queue can hold up to all nodes of the largest level)

Takeaway:
BFS space = O(n) worst-case (if tree is wide).
DFS space = O(h), better if tree height is small compared to width.


 */