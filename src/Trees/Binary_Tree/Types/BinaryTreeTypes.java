package Trees.Binary_Tree.Types;


class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class BinaryTreeTypes {

    // 1. Check Full Binary Tree (every node 0 or 2 children)
    static boolean isFull(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null)
            return isFull(root.left) && isFull(root.right);
        return false;
    }

    // 2. Check Perfect Binary Tree
    static int depth(Node node) {
        int d = 0;
        while (node != null) {
            d++;
            node = node.left;
        }
        return d;
    }

    static boolean isPerfect(Node root, int d, int level) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return (d == level + 1);
        if (root.left == null || root.right == null) return false;
        return isPerfect(root.left, d, level + 1) &&
                isPerfect(root.right, d, level + 1);
    }

    // 3. Check Complete Binary Tree
    static boolean isComplete(Node root, int index, int size) {
        if (root == null) return true;
        if (index >= size) return false;
        return isComplete(root.left, 2 * index + 1, size) &&
                isComplete(root.right, 2 * index + 2, size);
    }

    static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 4. Check Balanced Binary Tree
    static int checkHeight(Node root) {
        if (root == null) return 0;
        int lh = checkHeight(root.left);
        if (lh == -1) return -1;
        int rh = checkHeight(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    // 5. Check Degenerate (skewed like linked list)
    static boolean isDegenerate(Node root) {
        if (root == null) return true;
        if (root.left != null && root.right != null) return false;
        return isDegenerate(root.left) || isDegenerate(root.right);
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Full? " + isFull(root));            // true
        int d = depth(root);
        System.out.println("Perfect? " + isPerfect(root, d, 0));// false
        int size = countNodes(root);
        System.out.println("Complete? " + isComplete(root, 0, size)); // true
        System.out.println("Balanced? " + isBalanced(root));    // true
        System.out.println("Degenerate? " + isDegenerate(root));// false
    }

}
