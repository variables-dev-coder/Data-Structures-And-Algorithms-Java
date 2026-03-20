package Trees.treeRevision;

class InorderTraversal {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        inorder(root); // 2 1 3
    }
}
