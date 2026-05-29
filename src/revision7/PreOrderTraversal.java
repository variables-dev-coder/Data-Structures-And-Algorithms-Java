package revision7;

class Node1 {
    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
    }
}

public class PreOrderTraversal {

    static void preorder(Node1 root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Node1 root = new Node1(1);

        root.left = new Node1(2);
        root.right = new Node1(3);

        root.left.left = new Node1(4);
        root.left.right = new Node1(5);

        preorder(root);
    }
}
