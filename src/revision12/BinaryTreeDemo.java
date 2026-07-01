package revision12;

public class BinaryTreeDemo {

    static class TreeNode {

        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(5);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(25);

        System.out.println(root.data);
    }
}
