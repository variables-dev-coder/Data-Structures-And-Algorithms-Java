package Trees.treeRevision_BST;

import java.util.*;

public class BSTtoDLL {

    static class Node {
        int val;
        Node left, right; // left = prev, right = next

        Node(int val) {
            this.val = val;
        }
    }

    static Node prev = null;
    static Node head = null;

    public static void convert(Node root) {
        if (root == null) return;

        // left
        convert(root.left);

        // process current
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        // right
        convert(root.right);
    }

    public static Node bstToDLL(Node root) {
        prev = null;
        head = null;
        convert(root);
        return head;
    }

    // insert helper
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    // print DLL
    public static void printDLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node root = null;
        int[] arr = {4, 2, 5, 1, 3};

        for (int x : arr) {
            root = insert(root, x);
        }

        Node head = bstToDLL(root);

        System.out.print("Doubly Linked List: ");
        printDLL(head);
    }
}
