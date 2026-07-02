package revision12;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode5 {

    int data;
    TreeNode6 left;
    TreeNode6 right;

    TreeNode5(int data) {
        this.data = data;
    }
}

public class LevelOrderTraversal {

    static void levelOrder(TreeNode6 root) {

        if(root == null)
            return;

        Queue<TreeNode6> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {

            TreeNode6 current = queue.poll();

            System.out.print(current.data + " ");

            if(current.left != null)
                queue.offer(current.left);

            if(current.right != null)
                queue.offer(current.right);
        }
    }

    public static void main(String[] args) {

        TreeNode6 root = new TreeNode6(10);

        root.left = new TreeNode6(5);
        root.right = new TreeNode6(20);

        root.left.left = new TreeNode6(2);
        root.left.right = new TreeNode6(8);

        root.right.left = new TreeNode6(15);
        root.right.right = new TreeNode6(25);

        levelOrder(root);
    }
}
