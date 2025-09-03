package Trees.Binary_Tree.Day02_Complete_Binary_Tree;


import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class CompleteBinaryTree {
    Node root;

    // Insert using level order (BFS)
    public void insert(int data) {
        Node newNode = new Node(data);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            // insert left
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                q.add(temp.left);
            }

            // insert right
            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    // Level order traversal to print tree
    public void levelOrder() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        // Insert elements like heap
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);

        System.out.println("Level Order Traversal of Complete Binary Tree:");
        tree.levelOrder();
    }
}

/*
Level Order Traversal of Complete Binary Tree:
1 2 3 4 5 6


        1
      /   \
     2     3
    / \   /
   4   5 6

 */