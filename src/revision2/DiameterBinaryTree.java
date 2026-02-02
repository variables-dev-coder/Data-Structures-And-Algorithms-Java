package revision2;

public class DiameterBinaryTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(Node root) {
        height(root);
        return diameter;
    }

    private static int height(Node node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
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

        int result = diameterOfBinaryTree(root);
        System.out.println("Diameter of Binary Tree: " + result);
    }
}

// Diameter of Binary Tree: 3