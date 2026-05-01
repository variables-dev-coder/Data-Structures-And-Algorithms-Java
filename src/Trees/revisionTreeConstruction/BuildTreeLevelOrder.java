package Trees.revisionTreeConstruction;

import java.util.*;

public class BuildTreeLevelOrder {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node build(Integer[] arr) {

        if (arr.length == 0 || arr[0] == null) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            Node curr = queue.poll();

            // left child
            if (arr[i] != null) {
                curr.left = new Node(arr[i]);
                queue.add(curr.left);
            }
            i++;

            // right child
            if (i < arr.length && arr[i] != null) {
                curr.right = new Node(arr[i]);
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // print inorder
    public static void print(Node root) {
        if (root == null) return;
        print(root.left);
        System.out.print(root.val + " ");
        print(root.right);
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, null, 4, 5, 6};

        Node root = build(arr);

        System.out.print("Tree (Inorder): ");
        print(root);
    }
}
