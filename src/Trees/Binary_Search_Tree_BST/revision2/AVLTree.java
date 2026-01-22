package Trees.Binary_Search_Tree_BST.revision2;

// AVLTree.java - Self-balancing BST
class AVLNode {
    int val, height;
    AVLNode left, right;

    AVLNode(int val) {
        this.val = val;
        this.height = 1;
        this.left = this.right = null;
    }
}

public class AVLTree {
    private AVLNode root;

    // Get height of node
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Get balance factor
    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert into AVL tree
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private AVLNode insertRec(AVLNode node, int val) {
        // 1. Perform normal BST insert
        if (node == null) {
            return new AVLNode(val);
        }

        if (val < node.val) {
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        } else {
            return node; // Duplicate values not allowed
        }

        // 2. Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get balance factor
        int balance = getBalance(node);

        // 4. Handle 4 cases if unbalanced

        // Left Left Case
        if (balance > 1 && val < node.left.val) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && val > node.right.val) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(AVLNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    // Print tree
    public void printTree() {
        printTreeRec(root, 0);
    }

    private void printTreeRec(AVLNode root, int space) {
        if (root == null) return;

        space += 10;
        printTreeRec(root.right, space);

        System.out.println();
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "(h=" + root.height + ")");

        printTreeRec(root.left, space);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        System.out.println("=== AVL TREE DEMO (Self-Balancing) ===\n");

        // Insert values that would create an unbalanced BST
        int[] values = {10, 20, 30, 40, 50, 25};

        System.out.println("Inserting in order: " + java.util.Arrays.toString(values));
        System.out.println("\nTree after each insertion:");

        for (int i = 0; i < values.length; i++) {
            tree.insert(values[i]);
            System.out.println("\nAfter inserting " + values[i] + ":");
            tree.printTree();
            System.out.println("\nInorder traversal (sorted): ");
            tree.inorder();
            System.out.println("------------------------");
        }
    }
}
