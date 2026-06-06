package revision7;

class Node26 {

    int data;
    Node26 left;
    Node26 right;

    Node26(int data) {
        this.data = data;
    }
}

public class TreeToDLL {

    static Node26 head = null;
    static Node26 prev = null;

    static void convert(Node26 root) {

        if (root == null) {
            return;
        }

        // Left
        convert(root.left);

        // Current Node
        if (prev == null) {

            head = root;

        } else {

            prev.right = root;
            root.left = prev;
        }

        prev = root;

        // Right
        convert(root.right);
    }

    static void printDLL(Node26 head) {

        Node26 curr = head;

        while (curr != null) {

            System.out.print(
                    curr.data + " ");

            curr = curr.right;
        }
    }

    public static void main(String[] args) {

        Node26 root = new Node26(10);

        root.left = new Node26(5);
        root.right = new Node26(20);

        root.left.left = new Node26(3);
        root.left.right = new Node26(7);

        root.right.left = new Node26(15);

        convert(root);

        printDLL(head);
    }
}
