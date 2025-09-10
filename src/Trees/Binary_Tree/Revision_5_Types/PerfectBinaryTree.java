package Trees.Binary_Tree.Revision_5_Types;


class Node3 {
    int data;
    Node3 left, right;
    Node3(int data) {
        this.data = data;
    }
}

public class PerfectBinaryTree {
    static int depth(Node3 node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    static boolean isPerfect(Node3 root, int depth, int level) {
        if (root == null) return true;
        if (root.left == null && root.right == null)
            return depth == level + 1;
        if (root.left == null || root.right == null) return false;
        return isPerfect(root.left, depth, level + 1) &&
                isPerfect(root.right, depth, level + 1);
    }

    public static void main(String[] args) {
        Node3 root = new Node3(1);
        root.left = new Node3(2);
        root.right = new Node3(3);
        root.left.left = new Node3(4);
        root.left.right = new Node3(5);
        root.right.left = new Node3(6);
        root.right.right = new Node3(7);

        int depth = depth(root);
        System.out.println("Is Perfect Binary Tree? " + isPerfect(root, depth, 0));
    }

}


//Is Perfect Binary Tree? true