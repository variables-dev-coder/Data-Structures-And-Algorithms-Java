package Trees.treeRevision;

class BSTExample {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    // INSERT
    static Node insert(Node root, int val) {

        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // SEARCH
    static boolean search(Node root, int key) {

        if (root == null) return false;

        if (root.val == key) return true;

        if (key < root.val) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // INORDER (Sorted)
    static void inorder(Node root) {

        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // DELETE
    static Node delete(Node root, int key) {

        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        } else if (key > root.val) {
            root.right = delete(root.right, key);
        } else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Two children
            Node successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    // Find minimum (leftmost node)
    static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // MAIN
    public static void main(String[] args) {

        Node root = null;

        // Insert values
        int[] values = {5, 3, 7, 2, 4, 8};

        for (int v : values) {
            root = insert(root, v);
        }

        System.out.print("Inorder (sorted): ");
        inorder(root);  // 2 3 4 5 7 8

        System.out.println();

        // Search
        System.out.println("Search 4: " + search(root, 4)); // true
        System.out.println("Search 10: " + search(root, 10)); // false

        // Delete
        root = delete(root, 3);

        System.out.print("After deleting 3: ");
        inorder(root); // 2 4 5 7 8
    }
}
