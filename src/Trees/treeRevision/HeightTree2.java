package Trees.treeRevision;

public class HeightTree2 {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Height: " + height(root)); // 3
    }
}
