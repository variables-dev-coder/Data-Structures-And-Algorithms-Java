package Trees.Binary_Search_Tree_BST.day4_Traversals_BST;


class Node1 {
    int value;
    Node1 left, right;

    Node1(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BSTTraversal {
    // Inorder Traversal
    public static void inorder(Node1 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    public static void preorder(Node1 root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    public static void postorder(Node1 root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        // creating the BST
        Node1 root = new Node1(50);
        root.left = new Node1(30);
        root.right = new Node1(70);
        root.left.left = new Node1(20);
        root.left.right = new Node1(40);
        root.right.left = new Node1(60);
        root.right.right = new Node1(80);

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);
    }

}

//Inorder: 20 30 40 50 60 70 80
//Preorder: 50 30 20 40 70 60 80
//Postorder: 20 40 30 60 80 70 50 