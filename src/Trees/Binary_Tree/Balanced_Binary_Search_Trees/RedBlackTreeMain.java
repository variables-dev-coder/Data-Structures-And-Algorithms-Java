package Trees.Binary_Tree.Balanced_Binary_Search_Trees;

// Java Implementation (Simplified Version)

class Node {
    int data;
    Node left, right, parent;
    boolean color; // true = RED, false = BLACK

    Node(int data) {
        this.data = data;
        this.color = true; // new nodes are RED
    }
}

class RedBlackTree {
    private Node root;

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    private void fixViolation(Node node) {
        Node parent = null;
        Node grandparent = null;

        while (node != root && node.color && node.parent.color) {
            parent = node.parent;
            grandparent = parent.parent;

            // Case A: Parent is left child of grandparent
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Case 1: Uncle is red (recolor)
                if (uncle != null && uncle.color) {
                    grandparent.color = true;
                    parent.color = false;
                    uncle.color = false;
                    node = grandparent;
                } else {
                    // Case 2: node is right child -> rotate left
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    // Case 3: rotate right
                    rotateRight(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            } else { // Mirror cases
                Node uncle = grandparent.left;
                if (uncle != null && uncle.color) {
                    grandparent.color = true;
                    parent.color = false;
                    uncle.color = false;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    rotateLeft(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            }
        }
        root.color = false; // root always black
    }

    public void insert(int data) {
        Node node = new Node(data);
        root = bstInsert(root, node);
        fixViolation(node);
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null)
            return node;

        if (node.data < root.data) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(Node root) {
        if (root != null) {
            inorderHelper(root.left);
            System.out.print(root.data + (root.color ? "(R) " : "(B) "));
            inorderHelper(root.right);
        }
    }
}

public class RedBlackTreeMain {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int[] values = {10, 20, 30, 15, 25, 5};

        for (int v : values)
            tree.insert(v);

        System.out.println("Inorder traversal with colors:");
        tree.inorder();
    }
}

// 5(R) 10(B) 15(R) 20(B) 25(R) 30(B)