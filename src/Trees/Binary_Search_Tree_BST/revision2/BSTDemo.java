package Trees.Binary_Search_Tree_BST.revision2;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTDemo {

    // 1 Insert into BST
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // 2 Inorder Traversal (SORTED ORDER)
    static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 3 Search in BST
    static boolean search(TreeNode root, int key) {
        if (root == null) return false;

        if (root.data == key) return true;
        else if (key < root.data) return search(root.left, key);
        else return search(root.right, key);
    }

    // 4 Find Minimum Value
    static int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // 5 Find Maximum Value
    static int findMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // 6 Delete a Node from BST
    static TreeNode delete(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            else {
                int successor = findMin(root.right);
                root.data = successor;
                root.right = delete(root.right, successor);
            }
        }
        return root;
    }

    // 🔹 MAIN METHOD
    public static void main(String[] args) {

        TreeNode root = null;

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            root = insert(root, v);
        }

        System.out.print("Inorder (Sorted): ");
        inorder(root);

        System.out.println("\nSearch 40: " + search(root, 40));
        System.out.println("Search 90: " + search(root, 90));

        System.out.println("Minimum: " + findMin(root));
        System.out.println("Maximum: " + findMax(root));

        root = delete(root, 50);  // deleting root
        System.out.print("After deleting 50: ");
        inorder(root);
    }
}

/*

Inorder (Sorted): 20 30 40 50 60 70 80
Search 40: true
Search 90: false
Minimum: 20
Maximum: 80
After deleting 50: 20 30 40 60 70 80

 */