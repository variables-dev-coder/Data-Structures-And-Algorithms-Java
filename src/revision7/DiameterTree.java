package revision7;

class Node6 {
    int data;
    Node6 left, right;

    Node6(int data) {
        this.data = data;
    }
}

public class DiameterTree {

    static int diameter = 0;

    static int height(Node6 root) {

        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(
                diameter,
                left + right
        );

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        Node6 root = new Node6(1);

        root.left = new Node6(2);
        root.right = new Node6(3);

        root.left.left = new Node6(4);
        root.left.right = new Node6(5);

        height(root);

        System.out.println(diameter);
    }
}
