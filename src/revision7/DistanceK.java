package revision7;

class Node18 {

    int data;
    Node18 left, right;

    Node18(int data) {
        this.data = data;
    }
}

public class DistanceK {

    static void printK(
            Node18 root,
            int k) {

        if (root == null)
            return;

        if (k == 0) {

            System.out.print(
                    root.data + " ");
            return;
        }

        printK(root.left, k - 1);
        printK(root.right, k - 1);
    }

    public static void main(String[] args) {

        Node18 root = new Node18(1);

        root.left = new Node18(2);
        root.right = new Node18(3);

        root.left.left = new Node18(4);
        root.left.right = new Node18(5);

        printK(root, 2);
    }
}
