package Trees.Binary_Tree.Core_Operations;

// Insert in Binary Tree (Level Order)

import java.util.*;

public class BinaryTreeInsert {

    static class Node1 {
        int data;
        Node1 left, right;

        Node1(int data) {
            this.data = data;
        }
    }

    Node1 root;

    // Insert in level order
    public void insert(int key) {
        Node1 newNode = new Node1(key);

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node1> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node1 temp = q.poll();

            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                q.add(temp.right);
            }
        }
    }

    // Level-order traversal to print tree
    public void levelOrder() {
        if (root == null) return;

        Queue<Node1> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node1 temp = q.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeInsert tree = new BinaryTreeInsert();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        System.out.println("Level-order traversal after insertions:");
        tree.levelOrder();  // Output: 10 20 30 40 50
    }
}

// Level-order traversal after insertions:
//10 20 30 40 50

//Explanation:
//We use a queue (BFS) to find the first empty spot in the tree.
//Insert at left first, then right.