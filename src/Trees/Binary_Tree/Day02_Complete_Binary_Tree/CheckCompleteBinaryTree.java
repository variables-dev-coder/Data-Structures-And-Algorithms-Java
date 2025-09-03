package Trees.Binary_Tree.Day02_Complete_Binary_Tree;

import java.util.*;

class Node3 {
    int data;
    Node3 left, right;

    Node3(int data) {
        this.data = data;
        left = right = null;
    }
}

public class CheckCompleteBinaryTree {

    // Function to check if a binary tree is Complete Binary Tree
    public static boolean isComplete(Node3 root) {
        if (root == null) return true;

        Queue<Node3> q = new LinkedList<>();
        q.add(root);
        boolean end = false; // once a missing child is found, all next must be leaf

        while (!q.isEmpty()) {
            Node3 temp = q.poll();

            // Check left child
            if (temp.left != null) {
                if (end) return false; // violation
                q.add(temp.left);
            } else {
                end = true; // after this, no child should exist
            }

            // Check right child
            if (temp.right != null) {
                if (end) return false; // violation
                q.add(temp.right);
            } else {
                end = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Example 1: Complete Binary Tree
        Node3 root1 = new Node3(1);
        root1.left = new Node3(2);
        root1.right = new Node3(3);
        root1.left.left = new Node3(4);
        root1.left.right = new Node3(5);
        root1.right.left = new Node3(6);

        System.out.println("Tree 1 is Complete Binary Tree? " + isComplete(root1));

        //Example 2: Not a Complete Binary Tree
        Node3 root2 = new Node3(1);
        root2.left = new Node3(2);
        root2.right = new Node3(3);
        root2.left.right = new Node3(4); // left child missing → not complete

        System.out.println("Tree 2 is Complete Binary Tree? " + isComplete(root2));
    }
}

/*
Tree 1 is Complete Binary Tree? true
Tree 2 is Complete Binary Tree? false

Tree 1 (Complete):
        1
      /   \
     2     3
    / \   /
   4   5 6

Tree 2 (Not Complete):
        1
      /   \
     2     3
      \
       4


 */