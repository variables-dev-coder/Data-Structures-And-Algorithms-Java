package Trees.Binary_Tree.Binary_Tree_Traversals;


class Node3 {
    int val;
    Node3 left, right;

    Node3(int v) {
        val = v;
        left = right = null;
    }
}

public class PostorderTraversal {
    static void postorder(Node3 root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        Node3 root = new Node3(1);
        root.left = new Node3(2);
        root.right = new Node3(3);
        root.left.left = new Node3(4);
        root.left.right = new Node3(5);

        System.out.print("Postorder: ");
        postorder(root); // Output: 4 5 2 3 1
    }
}

//Postorder: 4 5 2 3 1 