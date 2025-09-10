package Trees.Binary_Tree.Revision_5_Types;



import java.util.*;

class Node2 {
    int data;
    Node2 left, right;
    Node2(int data) {
        this.data = data;
    }
}


public class CompleteBinaryTree {
    static boolean isComplete(Node2 root) {
        if (root == null) return true;
        Queue<Node2> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;

        while (!q.isEmpty()) {
            Node2 curr = q.poll();
            if (curr.left != null) {
                if (flag) return false;
                q.add(curr.left);
            } else flag = true;

            if (curr.right != null) {
                if (flag) return false;
                q.add(curr.right);
            } else flag = true;
        }
        return true;
    }

    public static void main(String[] args) {
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);
        root.right.left = new Node2(6);

        System.out.println("Is Complete Binary Tree? " + isComplete(root));
    }
}

//Is Complete Binary Tree? true


