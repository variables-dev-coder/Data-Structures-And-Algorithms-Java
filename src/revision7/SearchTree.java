package revision7;

class Node5 {
    int data;
    Node5 left, right;

    Node5(int data) {
        this.data = data;
    }
}

public class SearchTree {

    static boolean search(Node5 root, int target) {

        if (root == null)
            return false;

        if (root.data == target)
            return true;

        return search(root.left, target)
                || search(root.right, target);
    }

    public static void main(String[] args) {

        Node5 root = new Node5(1);

        root.left = new Node5(2);
        root.right = new Node5(3);

        root.left.left = new Node5(4);

        System.out.println(search(root, 4));
        System.out.println(search(root, 10));
    }
}
