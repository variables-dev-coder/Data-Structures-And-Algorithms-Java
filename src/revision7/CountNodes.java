package revision7;

class Node2 {
    int data;
    Node2 left, right;

    Node2(int data) {
        this.data = data;
    }
}

public class CountNodes {

    static int count(Node2 root) {

        if (root == null)
            return 0;

        return 1
                + count(root.left)
                + count(root.right);
    }

    public static void main(String[] args) {

        Node2 root = new Node2(1);

        root.left = new Node2(2);
        root.right = new Node2(3);

        root.left.left = new Node2(4);
        root.left.right = new Node2(5);

        System.out.println(count(root));
    }
}
