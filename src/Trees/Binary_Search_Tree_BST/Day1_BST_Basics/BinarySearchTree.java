package Trees.Binary_Search_Tree_BST.Day1_BST_Basics;


class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert method
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive insert Function
    Node insertRec(Node root, int key) {
        // Base case: if tree/subtree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // recursive case: decide to go left or right
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right,key);
        }

        // Return unchanged node pointer
        return root;
    }

    // Inorder traversal to verify sorted property
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes manually
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal (sorted): ");
        tree.inorder();
    }
}


//Inorder traversal (sorted):
//20 30 40 50 60 70 80

