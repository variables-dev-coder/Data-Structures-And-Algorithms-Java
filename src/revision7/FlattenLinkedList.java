package revision7;

class Node23 {

    int data;
    Node23 next;
    Node23 bottom;

    Node23(int data) {
        this.data = data;
    }
}

public class FlattenLinkedList {

    public static void main(String[] args) {

        /*
              5 -> 10 -> 19 -> 28
              |    |     |     |
              7    20    22    35
              |          |     |
              8          50    40
              |                |
              30               45
        */

        Node23 head = new Node23(5);

        head.bottom = new Node23(7);
        head.bottom.bottom = new Node23(8);
        head.bottom.bottom.bottom = new Node23(30);

        head.next = new Node23(10);
        head.next.bottom = new Node23(20);

        head.next.next = new Node23(19);
        head.next.next.bottom = new Node23(22);
        head.next.next.bottom.bottom = new Node23(50);

        head.next.next.next = new Node23(28);
        head.next.next.next.bottom = new Node23(35);
        head.next.next.next.bottom.bottom = new Node23(40);
        head.next.next.next.bottom.bottom.bottom = new Node23(45);

        FlattenLinkedList obj = new FlattenLinkedList();

        Node23 result = obj.flatten(head);

        System.out.println("Flattened List:");

        while (result != null) {

            System.out.print(
                    result.data + " ");

            result = result.bottom;
        }
    }

    public Node23 flatten(Node23 root) {

        if (root == null ||
                root.next == null) {

            return root;
        }

        root.next = flatten(root.next);

        root = merge(root, root.next);

        return root;
    }

    private Node23 merge(Node23 a, Node23 b) {

        if (a == null)
            return b;

        if (b == null)
            return a;

        Node23 result;

        if (a.data < b.data) {

            result = a;

            result.bottom =
                    merge(a.bottom, b);

        } else {

            result = b;

            result.bottom =
                    merge(a, b.bottom);
        }

        result.next = null;

        return result;
    }
}

//Flattened List:
//5 7 8 10 19 20 22 28 30 35 40 45 50