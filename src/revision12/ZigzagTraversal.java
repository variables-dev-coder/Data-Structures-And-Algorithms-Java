package revision12;

import java.util.*;

class TreeNode11 {

    int data;
    TreeNode11 left, right;

    TreeNode11(int data) {
        this.data = data;
    }
}

public class ZigzagTraversal {

    static void zigzag(TreeNode11 root) {

        if (root == null)
            return;

        Queue<TreeNode11> queue = new LinkedList<>();

        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode11 current = queue.poll();

                if (leftToRight)
                    level.add(current.data);
                else
                    level.add(0, current.data);

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }

            System.out.println(level);

            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {

        TreeNode11 root = new TreeNode11(1);

        root.left = new TreeNode11(2);
        root.right = new TreeNode11(3);

        root.left.left = new TreeNode11(4);
        root.left.right = new TreeNode11(5);

        root.right.left = new TreeNode11(6);
        root.right.right = new TreeNode11(7);

        zigzag(root);
    }
}
