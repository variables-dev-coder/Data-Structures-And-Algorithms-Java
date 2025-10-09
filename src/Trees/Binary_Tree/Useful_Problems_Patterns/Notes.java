package Trees.Binary_Tree.Useful_Problems_Patterns;

public class Notes {
    public static void main(String[] args) {

        /*

I will go one by one with:
    1 Lowest Common Ancestor (LCA)
    2 Diameter of Tree
    3 Path Sum / Root-to-Leaf Paths
    4 Level-Order Zigzag & Boundary Traversal
    5 Serialize / Deserialize Tree
    6 Convert Sorted Array → Balanced BST


1.Lowest Common Ancestor (LCA)
==============================
Definition:
LCA of two nodes is the lowest node in the tree that has both p and q as descendants.

Intuition:
    If current node is p or q, return it.
    Recur left and right:
        If both return non-null → current node is LCA.
        If one side null → LCA lies on the other side.

Code:

class Node {
    int val;
    Node left, right;

    Node (int val) {
    val = v;
    }

class BinaryTreeLCA {
    Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null || root == p || root == q)
            return root;

         Node left = lowestCommonAncestor(root.left, p, q)
         Node right = lowestCommonAncestor(root.right, p, q)

         if (left != null && right != null) return root;
         return (left != null) ? left : right;

    }
 }

Time: O(n), Space: O(h)
Example:
        3
       / \
      5   1
     / \  / \
    6  2 0  8
      / \
     7  4

LCA(5,1) = 3
LCA(5,4) = 5


2.Diameter of a Binary Tree
===========================
Definition:
The longest path between any two nodes in the tree.

Logic:
For every node:
    diameter = leftHeight + rightHeight

Track max diameter during recursion.

Code:

class Diameter {
    int max = 0;

    int height(Node root) {
        if (root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        max = Math.max(max, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    int diameter(Node root) {
        height(root);
        return max;
    }
}

Time: O(n)
Space: O(h)


3.Path Sum (Root to Leaf Sum)
=============================
Problem:
Return true if there exists a root-to-leaf path such that the sum of nodes = target.

Code:
class PathSum {
    boolean hasPathSum(Node root, int target) {
        if (root == null) return false;

        if (root.left == null && root.right == null)
            return target == root.val;

        return hasPathSum(root.left, target - root.val)
            || hasPathSum(root.right, target - root.val);
    }
}

Example:

Tree: 5 -> 4 -> 11 -> 7 -> 2
Target = 22 → True


4.Level-Order Zigzag Traversal
===============================
Problem:
Return level order but alternate directions on each level.

Idea:

Use queue + flag to reverse every alternate level.

Code:

import java.util.*;

class Zigzag {
    List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (leftToRight) level.add(node.val);
                else level.add(0, node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}

Time: O(n)
Space: O(n)


5.Serialize / Deserialize Tree
==============================
Definition:
Convert tree → string (for storage/transfer) and back.

Preorder with null markers (“#” for null)
Code:

class Codec {
    String serialize(Node root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    int index = 0;
    Node deserialize(String[] data) {
        if (index >= data.length || data[index].equals("#")) {
            index++;
            return null;
        }

        Node root = new Node(Integer.parseInt(data[index++]));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }

    Node deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;
        return deserialize(arr);
    }
}

Example:

Input:       1
             / \
            2   3
               / \
              4   5
Serialized:  "1,2,#,#,3,4,#,#,5,#,#"


6.Convert Sorted Array → Balanced BST
=====================================
Goal:
Given sorted array, build height-balanced BST.

Middle element becomes root recursively.
Code:

class SortedArrayToBST {
    Node sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        Node root = new Node(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }

    Node sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}

Time: O(n)
Space: O(log n)


Summary Table

| Problem               | Pattern                | Approach           | Time |
| --------------------- | ---------------------- | ------------------ | ---- |
| LCA                   | DFS + Divide & Conquer | Recursive          | O(n) |
| Diameter              | DFS + Height           | Recursive          | O(n) |
| Path Sum              | DFS + Backtracking     | Recursive          | O(n) |
| Zigzag Traversal      | BFS + Flag             | Queue              | O(n) |
| Serialize/Deserialize | DFS Preorder           | String + Recursion | O(n) |
| Sorted Array → BST    | Divide & Conquer       | Mid as root        | O(n) |



         */
    }
}
