package Trees.Binary_Search_Tree_BST.day13ComplexityOptimization;

class BSTHeightDemo {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // Calculate height of BST
    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Search in BST
    static boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;

        return key < root.val
                ? search(root.left, key)
                : search(root.right, key);
    }

    public static void main(String[] args) {

        Node root = null;

        // Sorted insertion (worst case)
        int[] data = {10, 20, 30, 40, 50, 60};

        for (int x : data) {
            root = insert(root, x);
        }

        System.out.println("Height of BST: " + height(root));
        System.out.println("Search 60: " + search(root, 60));
    }
}

//Height of BST: 6
//Search 60: true