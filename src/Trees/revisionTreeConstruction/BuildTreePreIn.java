package Trees.revisionTreeConstruction;

import java.util.*;

public class BuildTreePreIn {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int preIndex = 0;

    public static Node build(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map) {

        if (start > end) return null;

        int rootVal = preorder[preIndex++];
        Node root = new Node(rootVal);

        int inIndex = map.get(rootVal);

        root.left = build(preorder, inorder, start, inIndex - 1, map);
        root.right = build(preorder, inorder, inIndex + 1, end, map);

        return root;
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, inorder.length - 1, map);
    }

    public static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Node root = buildTree(preorder, inorder);

        System.out.print("Inorder: ");
        inorderPrint(root);
    }
}
