package revision12;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode5 {

    int data;
    TreeNode5 left;
    TreeNode5 right;

    TreeNode5(int data) {
        this.data = data;
    }
}

public class LevelOrderTraversal {

    static void levelOrder(TreeNode5 root) {

        if(root == null)
            return;

        Queue<TreeNode5> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()) {

            TreeNode5 current = queue.poll();

            System.out.print(current.data + " ");

            if(current.left != null)
                queue.offer(current.left);

            if(current.right != null)
                queue.offer(current.right);
        }
    }

    public static void main(String[] args) {

        TreeNode5 root = new TreeNode5(10);

        root.left = new TreeNode5(5);
        root.right = new TreeNode5(20);

        root.left.left = new TreeNode5(2);
        root.left.right = new TreeNode5(8);

        root.right.left = new TreeNode5(15);
        root.right.right = new TreeNode5(25);

        levelOrder(root);
    }
}
