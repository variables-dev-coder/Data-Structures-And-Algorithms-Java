package revision12;

import java.util.*;

class TreeNode9 {

    int data;
    TreeNode9 left, right;

    TreeNode9(int data) {
        this.data = data;
    }
}

public class LeftView {

    static void leftView(TreeNode9 root) {

        if (root == null)
            return;

        Queue<TreeNode9> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode9 current = queue.poll();

                if (i == 0)
                    System.out.print(current.data + " ");

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode9 root = new TreeNode9(1);

        root.left = new TreeNode9(2);
        root.right = new TreeNode9(3);

        root.left.left = new TreeNode9(4);
        root.left.right = new TreeNode9(5);

        root.right.right = new TreeNode9(6);

        leftView(root);
    }
}
