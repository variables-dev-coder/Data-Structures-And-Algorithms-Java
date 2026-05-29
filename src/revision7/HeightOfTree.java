package revision7;

class Node3 {
    int data;
    Node3 left, right;

    Node3(int data) {
        this.data = data;
    }
}

public class HeightOfTree {

    static int height(Node3 root) {

        if (root == null)
            return 0;

        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
    }

    public static void main(String[] args) {

        Node3 root = new Node3(1);

        root.left = new Node3(2);
        root.right = new Node3(3);

        root.left.left = new Node3(4);

        System.out.println(height(root));
    }
}
