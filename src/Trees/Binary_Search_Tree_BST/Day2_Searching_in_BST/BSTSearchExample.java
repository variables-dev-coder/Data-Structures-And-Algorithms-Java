package Trees.Binary_Search_Tree_BST.Day2_Searching_in_BST;

public class BSTSearchExample {

    // Node definition
    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
        }
    }

    // BST class
    static class BinarySearchTree {
        Node root;

        // Insert a new key
        Node insert(Node root, int key) {
            if (root == null) {
                return new Node(key);
            }
            if (key < root.key)
                root.left = insert(root.left, key);
            else if (key > root.key)
                root.right = insert(root.right, key);
            return root;
        }

        // Recursive search
        Node searchRecursive(Node root, int key) {
            if (root == null || root.key == key)
                return root; // base case
            if (key < root.key)
                return searchRecursive(root.left, key);
            else
                return searchRecursive(root.right, key);
        }

        // Iterative search
        Node searchIterative(Node root, int key) {
            Node current = root;
            while (current != null) {
                if (key == current.key)
                    return current;
                else if (key < current.key)
                    current = current.left;
                else
                    current = current.right;
            }
            return null;
        }

        // Inorder traversal (to verify BST structure)
        void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.key + " ");
                inorder(root.right);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;

        // Build the BST
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int key : keys)
            root = bst.insert(root, key);

        System.out.print("Inorder Traversal: ");
        bst.inorder(root);
        System.out.println("\n---------------------");

        //  Recursive search test
        int searchKey1 = 60;
        Node result1 = bst.searchRecursive(root, searchKey1);
        System.out.println("Recursive Search for " + searchKey1 + ": " +
                (result1 != null ? "Found " : "Not Found "));

        //  Iterative search test
        int searchKey2 = 25;
        Node result2 = bst.searchIterative(root, searchKey2);
        System.out.println("Iterative Search for " + searchKey2 + ": " +
                (result2 != null ? "Found " : "Not Found "));
    }
}

/*
Inorder Traversal: 20 30 40 50 60 70 80
---------------------
Recursive Search for 60: Found
Iterative Search for 25: Not Found


Dry Run (Search 60 in BST)
Tree structure built:

        50
       /  \
     30    70
    / \    / \
   20 40  60 80

Recursive Search for 60:

Start at root = 50 → 60 > 50 → go right

Node = 70 → 60 < 70 → go left

Node = 60 → Match found

Iterative Search for 25:

Start at 50 → 25 < 50 → go left

Node = 30 → 25 < 30 → go left

Node = 20 → 25 > 20 → go right → null → Not Found



 */