package revision5;

class FlattenLinkedList {

    static class Node {
        int data;
        Node next, bottom;

        Node(int d) {
            data = d;
            next = bottom = null;
        }
    }

    public static Node merge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null;
        return result;
    }

    public static Node flatten(Node root) {

        if (root == null || root.next == null) return root;

        root.next = flatten(root.next);

        root = merge(root, root.next);

        return root;
    }
}
