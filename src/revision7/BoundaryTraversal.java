package revision7;

import java.util.*;

class Node17 {

    int data;
    Node17 left, right;

    Node17(int data) {
        this.data = data;
    }
}

public class BoundaryTraversal {

    static void leftBoundary(Node17 root) {

        Node17 curr = root.left;

        while (curr != null) {

            if (!(curr.left == null &&
                    curr.right == null)) {

                System.out.print(curr.data + " ");
            }

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    static void leaves(Node17 root) {

        if (root == null)
            return;

        if (root.left == null &&
                root.right == null) {

            System.out.print(root.data + " ");
            return;
        }

        leaves(root.left);
        leaves(root.right);
    }

    static void rightBoundary(Node17 root) {

        Stack<Integer> stack =
                new Stack<>();

        Node17 curr = root.right;

        while (curr != null) {

            if (!(curr.left == null &&
                    curr.right == null)) {

                stack.push(curr.data);
            }

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        while (!stack.isEmpty()) {

            System.out.print(
                    stack.pop() + " ");
        }
    }

    static void boundary(Node17 root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");

        leftBoundary(root);

        leaves(root);

        rightBoundary(root);
    }

    public static void main(String[] args) {

        Node17 root = new Node17(1);

        root.left = new Node17(2);
        root.right = new Node17(3);

        root.left.left = new Node17(4);
        root.left.right = new Node17(5);

        root.right.left = new Node17(6);
        root.right.right = new Node17(7);

        root.left.right.left =
                new Node17(8);

        root.left.right.right =
                new Node17(9);

        boundary(root);
    }
}
