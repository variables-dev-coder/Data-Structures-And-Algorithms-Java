package Trees.Binary_Tree.Core_Operations;


/*
2. Delete in Binary Tree (Level Order Deletion)
        In a Binary Tree (not BST), deletion works like this:
        Find the node to delete.
        Find the deepest rightmost node in the tree.
        Replace the node-to-delete’s value with that deepest node’s value.
        Delete the deepest node.
 */


import java.util.*;

public class BinaryTreeDelete {
    static class Node2 {
        int data;
        Node2 left, right;

        Node2(int data) {
            this.data = data;
        }
    }

    Node2 root;

    // Helper: Level-order traversal
    public void levelOrder() {
        if (root == null) return;

        Queue<Node2> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node2 temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
        System.out.println();
    }

    // Delete a node
    public void delete(int key) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.data == key) root = null;
            return;
        }

        Queue<Node2> q = new LinkedList<>();
        q.add(root);

        Node2 keyNode = null;
        Node2 temp = null;

        // Step 1: Find node with given key & track last node
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.data == key) {
                keyNode = temp;
            }
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }

        if (keyNode != null) {
            // Step 2: Replace data with deepest node
            int x = temp.data; // last node's data
            keyNode.data = x;

            // Step 3: Delete deepest node
            deleteDeepest(temp);
        }
    }

    // Helper: delete deepest node
    private void deleteDeepest(Node2 delNode) {
        Queue<Node2> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node2 temp = q.poll();
            if (temp == delNode) {
                temp = null;
                return;
            }
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else q.add(temp.left);
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else q.add(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeDelete tree = new BinaryTreeDelete();

        // Build tree manually
        tree.root = new Node2(10);
        tree.root.left = new Node2(20);
        tree.root.right = new Node2(30);
        tree.root.left.left = new Node2(40);
        tree.root.left.right = new Node2(50);

        System.out.println("Before Deletion (Level-order):");
        tree.levelOrder(); // 10 20 30 40 50

        tree.delete(20);

        System.out.println("After Deletion (Level-order):");
        tree.levelOrder(); // 10 50 30 40
    }
}

//Before Deletion (Level-order):
//10 20 30 40 50
//After Deletion (Level-order):
//10 50 30 40

