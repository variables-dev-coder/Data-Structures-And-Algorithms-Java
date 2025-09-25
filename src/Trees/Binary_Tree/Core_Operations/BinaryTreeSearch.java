package Trees.Binary_Tree.Core_Operations;


//Search / Find in Binary Tree
//Goal: Given a value, check whether it exists in the tree.

import java.util.*;

public class BinaryTreeSearch {
    static class Node3 {
        int data;
        Node3 left, right;

        Node3(int data) {
            this.data = data;
        }
    }

    Node3 root;

    // BFS Search (Level-order)
    public boolean search(int key) {
        if (root == null) return false;

        Queue<Node3> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node3 temp = q.poll();

            if (temp.data == key) return true;

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTreeSearch tree = new BinaryTreeSearch();

        // Build tree manually
        tree.root = new Node3(10);
        tree.root.left = new Node3(20);
        tree.root.right = new Node3(30);
        tree.root.left.left = new Node3(40);
        tree.root.left.right = new Node3(50);

        System.out.println("Searching 30: " + tree.search(30)); // true
        System.out.println("Searching 60: " + tree.search(60)); // false
    }
}

//Searching 30: true
//Searching 60: false