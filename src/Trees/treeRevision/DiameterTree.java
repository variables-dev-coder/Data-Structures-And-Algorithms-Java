package Trees.treeRevision;

public class DiameterTree {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static int diameter = 0;

    static int height(Node root) {

        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        height(root);

        System.out.println("Diameter: " + diameter);
    }
}
