package Trees.revisionTreeConstruction;

import java.util.*;

public class BuildTreeInLevel {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node build(int[] inorder, List<Integer> level) {

        if (inorder.length == 0) return null;

        int rootVal = level.get(0);
        Node root = new Node(rootVal);

        int index = 0;
        while (inorder[index] != rootVal) index++;

        Set<Integer> leftSet = new HashSet<>();
        for (int i = 0; i < index; i++) {
            leftSet.add(inorder[i]);
        }

        List<Integer> leftLevel = new ArrayList<>();
        List<Integer> rightLevel = new ArrayList<>();

        for (int val : level) {
            if (leftSet.contains(val)) leftLevel.add(val);
            else if (val != rootVal) rightLevel.add(val);
        }

        root.left = build(Arrays.copyOfRange(inorder, 0, index), leftLevel);
        root.right = build(Arrays.copyOfRange(inorder, index + 1, inorder.length), rightLevel);

        return root;
    }

    public static void main(String[] args) {

        int[] inorder = {4, 8, 10, 12, 14, 20, 22};
        List<Integer> level = Arrays.asList(20, 8, 22, 4, 12, 10, 14);

        Node root = build(inorder, level);

        System.out.println("Tree built successfully");
    }
}
