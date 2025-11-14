package Trees.Binary_Search_Tree_BST.Day3_Deletion_In_BST;

public class BSTDeleteMastery {

    static class Node {
        int key;
        Node left, right;
        Node(int k) { key = k; }
    }

    static class BST {
        Node root;

        // Insert (recursive)
        Node insert(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key) node.left = insert(node.left, key);
            else if (key > node.key) node.right = insert(node.right, key);
            // ignoring equal keys (no duplicates) - can be adapted
            return node;
        }

        // Find min node in subtree (used for inorder successor)
        Node minNode(Node node) {
            Node cur = node;
            while (cur != null && cur.left != null) cur = cur.left;
            return cur;
        }

        // Delete key from BST and return new subtree root
        Node delete(Node node, int key) {
            if (node == null) return null;

            // 1) Search for the node to delete
            if (key < node.key) {
                node.left = delete(node.left, key);
            } else if (key > node.key) {
                node.right = delete(node.right, key);
            } else {
                // node.key == key  -> node to be deleted found

                // CASE A: No child (leaf)
                if (node.left == null && node.right == null) {
                    return null; // garbage-collected (in Java)
                }

                // CASE B: One child
                if (node.left == null) {
                    return node.right; // replace node with right child
                } else if (node.right == null) {
                    return node.left;  // replace node with left child
                }

                // CASE C: Two children
                //  - Get inorder successor (smallest in right subtree)
                Node successor = minNode(node.right);
                //  - Copy successor's key to this node
                node.key = successor.key;
                //  - Delete successor in right subtree
                node.right = delete(node.right, successor.key);
            }
            return node;
        }

        // Inorder traversal
        void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.key + " ");
                inorder(node.right);
            }
        }

        // Pretty-print tree (simple, sideways)
        void printSideways(Node node, String prefix) {
            if (node == null) return;
            printSideways(node.right, prefix + "    ");
            System.out.println(prefix + node.key);
            printSideways(node.left, prefix + "    ");
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int k : keys) tree.root = tree.insert(tree.root, k);

        System.out.println("Original tree (inorder):");
        tree.inorder(tree.root);
        System.out.println("\n\nOriginal tree (sideways):");
        tree.printSideways(tree.root, "");

        // Case 1: delete leaf 20
        System.out.println("\n\nDeleting leaf 20...");
        tree.root = tree.delete(tree.root, 20);
        tree.inorder(tree.root);
        System.out.println("\nSideways after deleting 20:");
        tree.printSideways(tree.root, "");

        // Case 2: delete node with one child (delete 30 which now has one child 40)
        System.out.println("\n\nDeleting node 30 (one child)...");
        tree.root = tree.delete(tree.root, 30);
        tree.inorder(tree.root);
        System.out.println("\nSideways after deleting 30:");
        tree.printSideways(tree.root, "");

        // Case 3: delete node with two children (delete 50)
        System.out.println("\n\nDeleting node 50 (two children)...");
        tree.root = tree.delete(tree.root, 50);
        tree.inorder(tree.root);
        System.out.println("\nSideways after deleting 50:");
        tree.printSideways(tree.root, "");
    }
}

/*

Original tree (inorder):
20 30 40 50 60 70 80

Original tree (sideways):
        80
    70
        60
50
        40
    30
        20


Deleting leaf 20...
30 40 50 60 70 80
Sideways after deleting 20:
        80
    70
        60
50
        40
    30


Deleting node 30 (one child)...
40 50 60 70 80
Sideways after deleting 30:
        80
    70
        60
50
    40


Deleting node 50 (two children)...
40 60 70 80
Sideways after deleting 50:
        80
    70
60
    40

 */