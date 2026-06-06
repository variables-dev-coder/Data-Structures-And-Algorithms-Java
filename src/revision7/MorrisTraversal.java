package revision7;

class Node27 {

    int data;
    Node27 left;
    Node27 right;

    Node27(int data) {
        this.data = data;
    }
}

public class MorrisTraversal {

    static void morrisInorder(Node27 root) {

        Node27 current = root;

        while (current != null) {

            // No left child
            if (current.left == null) {

                System.out.print(
                        current.data + " ");

                current = current.right;
            }

            else {

                Node27 predecessor =
                        current.left;

                // find rightmost node
                while (predecessor.right != null
                        && predecessor.right != current) {

                    predecessor =
                            predecessor.right;
                }

                // create thread
                if (predecessor.right == null) {

                    predecessor.right =
                            current;

                    current =
                            current.left;
                }

                // thread already exists
                else {

                    predecessor.right =
                            null;

                    System.out.print(
                            current.data + " ");

                    current =
                            current.right;
                }
            }
        }
    }

    public static void main(String[] args) {

        Node27 root = new Node27(10);

        root.left = new Node27(5);
        root.right = new Node27(20);

        root.left.left = new Node27(3);
        root.left.right = new Node27(7);

        root.right.left = new Node27(15);

        morrisInorder(root);
    }
}
