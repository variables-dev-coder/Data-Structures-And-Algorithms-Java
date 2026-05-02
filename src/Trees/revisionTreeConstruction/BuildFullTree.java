package Trees.revisionTreeConstruction;

import java.util.*;

public class BuildFullTree {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int preIndex = 0;

    public static Node build(int[] preorder, int[] postorder, int start, int end, Map<Integer, Integer> map) {

        if (preIndex >= preorder.length || start > end) return null;

        Node root = new Node(preorder[preIndex++]);

        if (start == end) return root;

        int nextVal = preorder[preIndex];
        int index = map.get(nextVal);

        root.left = build(preorder, postorder, start, index, map);
        root.right = build(preorder, postorder, index + 1, end - 1, map);

        return root;
    }

    public static Node buildTree(int[] preorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        preIndex = 0;
        return build(preorder, postorder, 0, postorder.length - 1, map);
    }

    public static void main(String[] args) {

        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        Node root = buildTree(preorder, postorder);

        System.out.println("Full Tree built successfully");
    }
}
