package Trees.Binary_Search_Tree_BST.day4_Traversals_BST;


import java.util.LinkedList;
import java.util.Queue;

class Node3 {
    int value;
    Node3 left, right;

    Node3(int value) {
        this.value = value;
    }
}

public class BSTTraversals2 {

    // 1. Inorder (Left → Root → Right)
    public static void inorder(Node3 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    // 2. Preorder (Root → Left → Right)
    public static void preorder(Node3 root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 3. Postorder (Left → Right → Root)
    public static void postorder(Node3 root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    // 4. Level Order (Breadth-First Search)
    public static void levelOrder(Node3 root) {
        if (root == null) return;

        Queue<Node3> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node3 current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    public static void main(String[] args) {

        // Build BST manually
        Node3 root = new Node3(50);
        root.left = new Node3(30);
        root.right = new Node3(70);
        root.left.left = new Node3(20);
        root.left.right = new Node3(40);
        root.right.left = new Node3(60);
        root.right.right = new Node3(80);

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        System.out.print("\nLevel Order: ");
        levelOrder(root);
    }
}


//Inorder: 20 30 40 50 60 70 80
//Preorder: 50 30 20 40 70 60 80
//Postorder: 20 40 30 60 80 70 50
//Level Order: 50 30 70 20 40 60 80