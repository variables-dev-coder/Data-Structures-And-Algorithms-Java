package Trees.Binary_Tree.Day02_Complete_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCBT {
    // Function to check if tree is Complete Binary Tree
    public static boolean isComplete(Node root) {
        if (root == null) return true;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean end = false;

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp.left != null) {
                if (end) return false; // violation
                q.add(temp.left);
            } else {
                end = true; // no more children should exist
            }

            if (temp.right != null) {
                if (end) return false; // violation
                q.add(temp.right);
            } else {
                end = true;
            }
        }
        return true;
    }
}
