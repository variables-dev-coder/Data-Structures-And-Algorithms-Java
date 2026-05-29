package revision7;

class Node4 {
    int data;
    Node4 left, right;

    Node4(int data) {
        this.data = data;
    }
}

public class CountLeafNodes {

    static int countLeaf(Node4 root) {

        if (root == null)
            return 0;

        if (root.left == null &&
                root.right == null)
            return 1;

        return countLeaf(root.left)
                + countLeaf(root.right);
    }

    public static void main(String[] args) {

        Node4 root = new Node4(1);

        root.left = new Node4(2);
        root.right = new Node4(3);

        root.left.left = new Node4(4);
        root.left.right = new Node4(5);

        System.out.println(countLeaf(root));
    }
}
