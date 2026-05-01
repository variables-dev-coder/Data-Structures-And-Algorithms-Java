package Trees.revisionTreeConstruction;

import java.util.*;

public class BuildTreePostIn {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int postIndex;

    public static Node build(int[] postorder, int start, int end, Map<Integer, Integer> map) {
        if (start > end) return null;

        int rootVal = postorder[postIndex--];
        Node root = new Node(rootVal);

        int inIndex = map.get(rootVal);

        // 🔥 IMPORTANT: right first
        root.right = build(postorder, inIndex + 1, end, map);
        root.left = build(postorder, start, inIndex - 1, map);

        return root;
    }

    public static Node buildTree(int[] postorder, int[] inorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(postorder, 0, inorder.length - 1, map);
    }

    // inorder print to verify
    public static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public static void main(String[] args) {

        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};

        Node root = buildTree(postorder, inorder);

        System.out.print("Tree (Inorder): ");
        print(root);
    }
}
