package revision7;

class Node16 {

    int data;
    Node16 left, right;

    Node16(int data) {
        this.data = data;
    }
}

public class SerializeTree {

    static void serialize(Node16 root) {

        if (root == null) {

            System.out.print("# ");
            return;
        }

        System.out.print(
                root.data + " ");

        serialize(root.left);
        serialize(root.right);
    }

    public static void main(String[] args) {

        Node16 root = new Node16(1);

        root.left = new Node16(2);
        root.right = new Node16(3);

        serialize(root);
    }
}
