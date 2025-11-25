package Trees.Binary_Search_Tree_BST.day4_Traversals_BST;


import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    int value;
    Node2 left, right;

    Node2(int value) {
        this.value = value;
    }
}

public class LevelOrderTraversal {

    public static void levelOrder(Node2 root) {
        if (root == null) return;

        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node2 curr = queue.poll();
            System.out.print(curr.value + " ");

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Node2 root = new Node2(50);
        root.left = new Node2(30);
        root.right = new Node2(70);
        root.left.left = new Node2(20);
        root.left.right = new Node2(40);
        root.right.left = new Node2(60);
        root.right.right = new Node2(80);

        System.out.print("Level Order: ");
        levelOrder(root);
    }

}

// Level Order: 50 30 70 20 40 60 80