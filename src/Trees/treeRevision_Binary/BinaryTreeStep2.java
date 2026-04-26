package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeStep2 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Inorder: Left → Root → Right
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Postorder: Left → Right → Root
    public static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);
    }
}
