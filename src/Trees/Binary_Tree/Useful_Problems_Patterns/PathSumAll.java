package Trees.Binary_Tree.Useful_Problems_Patterns;

import java.util.*;

class TreeNode4 {
    int val;
    TreeNode4 left, right;

    TreeNode4(int val) {
        this.val = val;
    }
}

public class PathSumAll {
    public List<List<Integer>> pathSum(TreeNode4 root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void findPaths(TreeNode4 node, int sum, List<Integer> current, List<List<Integer>> result) {
        if (node == null) return;

        current.add(node.val);

        // Leaf node and sum match
        if (node.left == null && node.right == null && sum == node.val) {
            result.add(new ArrayList<>(current));
        } else {
            findPaths(node.left, sum - node.val, current, result);
            findPaths(node.right, sum - node.val, current, result);
        }

        current.remove(current.size() - 1); // backtrack
    }

    public static void main(String[] args) {
        TreeNode4 root = new TreeNode4(5);
        root.left = new TreeNode4(4);
        root.right = new TreeNode4(8);
        root.left.left = new TreeNode4(11);
        root.left.left.left = new TreeNode4(7);
        root.left.left.right = new TreeNode4(2);
        root.right.left = new TreeNode4(13);
        root.right.right = new TreeNode4(4);
        root.right.right.right = new TreeNode4(1);

        PathSumAll ps = new PathSumAll();
        System.out.println(ps.pathSum(root, 22));
    }
}

//[[5, 4, 11, 2], [5, 8, 4, 5]]

//Key Takeaways

//Recursion + Backtracking helps in all root-to-leaf path problems.
//hasPathSum → boolean (exists or not)
//pathSum → list of all valid paths
//Real-world use: decision trees, network path costs, dependency analysis.