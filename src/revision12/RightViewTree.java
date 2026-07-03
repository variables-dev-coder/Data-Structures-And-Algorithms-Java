package revision12;

import java.util.*;

class TreeNode10 {

    int data;
    TreeNode10 left, right;

    TreeNode10(int data) {
        this.data = data;
    }
}

public class RightViewTree {

    static void rightView(TreeNode10 root) {

        if (root == null)
            return;

        Queue<TreeNode10> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode10 current = queue.poll();

                if (i == size - 1)
                    System.out.print(current.data + " ");

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode10 root = new TreeNode10(1);

        root.left = new TreeNode10(2);
        root.right = new TreeNode10(3);

        root.left.left = new TreeNode10(4);
        root.left.right = new TreeNode10(5);

        root.right.right = new TreeNode10(6);

        System.out.print("Right View: ");
        rightView(root);
    }
}
