package Trees.Binary_Tree.Balanced_Binary_Search_Trees;

// AVL Tree Insertion with Rotations

class AVLNode {
    int key, height;
    AVLNode left, right;
    AVLNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

class AVLTree {
    AVLNode root;

    int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    AVLNode rightRotate(AVLNode y) {
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

    AVLNode leftRotate(AVLNode x) {
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

    AVLNode insert(AVLNode node, int key) {
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // duplicates not allowed

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check balance
        int balance = getBalance(node);

        // 4 cases
        if (balance > 1 && key < node.left.key)
            return rightRotate(node); // LL
        if (balance < -1 && key > node.right.key)
            return leftRotate(node); // RR
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node); // LR
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node); // RL
        }

        return node;
    }

    void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}

public class AVLTreeMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = {10, 20, 30, 40, 50, 25};

        for (int val : values)
            tree.root = tree.insert(tree.root, val);

        System.out.print("Preorder traversal: ");
        tree.preOrder(tree.root);
    }
}

// Preorder traversal: 30 20 10 25 40 50