package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeRightView {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static List<Integer> rightView(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                // last node of level
                if (i == size - 1) {
                    result.add(curr.val);
                }

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
               \   \
                5   4
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(5);
        root.right.right = new Node(4);

        List<Integer> view = rightView(root);

        System.out.println("Right View: " + view);
    }
}
