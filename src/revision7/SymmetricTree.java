package revision7;

class Node {

    int data;
    Node19 left, right;

    Node(int data) {
        this.data = data;
    }
}

public class SymmetricTree {

    static boolean mirror(
            Node19 a,
            Node19 b) {

        if (a == null &&
                b == null)
            return true;

        if (a == null ||
                b == null)
            return false;

        return a.data == b.data
                && mirror(
                a.left,
                b.right)
                && mirror(
                a.right,
                b.left);
    }

    static boolean isSymmetric(
            Node19 root) {

        return mirror(
                root.left,
                root.right);
    }

    public static void main(String[] args) {

        Node19 root = new Node19(1);

        root.left = new Node19(2);
        root.right = new Node19(2);

        root.left.left = new Node19(3);
        root.left.right = new Node19(4);

        root.right.left = new Node19(4);
        root.right.right = new Node19(3);

        System.out.println(
                isSymmetric(root));
    }
}
