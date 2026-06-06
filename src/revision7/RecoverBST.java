package revision7;

class Node28 {

    int data;
    Node28 left;
    Node28 right;

    Node28(int data) {
        this.data = data;
    }
}

public class RecoverBST {

    static Node28 first = null;
    static Node28 second = null;
    static Node28 prev = null;

    static void inorder(Node28 root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null &&
                prev.data > root.data) {

            if (first == null) {

                first = prev;
            }

            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    static void recoverTree(Node28 root) {

        inorder(root);

        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    static void printInorder(Node28 root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);

        System.out.print(
                root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) {

        Node28 root = new Node28(4);

        root.left = new Node28(2);
        root.right = new Node28(3);

        root.left.left = new Node28(1);
        root.left.right = new Node28(6);

        root.right.left = new Node28(5);
        root.right.right = new Node28(7);

        System.out.println(
                "Before Recovery:");

        printInorder(root);

        recoverTree(root);

        System.out.println(
                "\nAfter Recovery:");

        printInorder(root);
    }
}
