package Trees.Binary_Search_Tree_BST.revision2;

// CompleteBST.java
public class CompleteBST {
    private TreeNode root;

    public CompleteBST() {
        root = null;
    }

    // INSERT
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }

        return root;
    }

    // DELETE - Most Important & Tricky!
    public void delete(int val) {
        root = deleteRec(root, val);
    }

    private TreeNode deleteRec(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        // Find the node to delete
        if (val < root.val) {
            root.left = deleteRec(root.left, val);
        } else if (val > root.val) {
            root.right = deleteRec(root.right, val);
        } else {
            // Node found! Now handle 3 cases:

            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            // Get inorder successor (smallest in right subtree)
            root.val = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.val);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    // FIND MINIMUM VALUE
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMinRec(root);
    }

    private int findMinRec(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // FIND MAXIMUM VALUE
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return findMaxRec(root);
    }

    private int findMaxRec(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    // FIND HEIGHT OF TREE
    public int height() {
        return heightRec(root);
    }

    private int heightRec(TreeNode root) {
        if (root == null) {
            return -1; // Height of empty tree is -1, height of single node is 0
        }

        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // COUNT TOTAL NODES
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    // CHECK IF TREE IS VALID BST
    public boolean isValidBST() {
        return isValidBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTRec(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBSTRec(root.left, min, root.val) &&
                isValidBSTRec(root.right, root.val, max);
    }

    // FIND KTH SMALLEST ELEMENT
    public int kthSmallest(int k) {
        if (k <= 0 || k > countNodes()) {
            throw new IllegalArgumentException("Invalid k value");
        }

        int[] result = new int[1];
        int[] count = new int[1];
        kthSmallestRec(root, k, count, result);
        return result[0];
    }

    private void kthSmallestRec(TreeNode root, int k, int[] count, int[] result) {
        if (root == null) {
            return;
        }

        kthSmallestRec(root.left, k, count, result);

        count[0]++;
        if (count[0] == k) {
            result[0] = root.val;
            return;
        }

        kthSmallestRec(root.right, k, count, result);
    }

    // LOWEST COMMON ANCESTOR (LCA)
    public int lca(int p, int q) {
        TreeNode node = lcaRec(root, p, q);
        return node != null ? node.val : -1;
    }

    private TreeNode lcaRec(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }

        // If both values are smaller, LCA is in left subtree
        if (p < root.val && q < root.val) {
            return lcaRec(root.left, p, q);
        }

        // If both values are larger, LCA is in right subtree
        if (p > root.val && q > root.val) {
            return lcaRec(root.right, p, q);
        }

        // If one is on left and one on right, or one is the root
        return root;
    }

    // INORDER SUCCESSOR
    public Integer inorderSuccessor(int val) {
        TreeNode successor = null;
        TreeNode current = root;

        // First, find the node
        while (current != null && current.val != val) {
            if (val < current.val) {
                successor = current; // Potential successor
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return null; // Node not found
        }

        // Case 1: Node has right subtree
        if (current.right != null) {
            return findMinRec(current.right);
        }

        // Case 2: No right subtree, return saved successor
        return successor != null ? successor.val : null;
    }

    // PRINT TREE VISUALLY
    public void printTree() {
        printTreeRec(root, 0, "Root: ");
    }

    private void printTreeRec(TreeNode root, int level, String prefix) {
        if (root == null) {
            return;
        }

        String indent = "  ".repeat(level);
        System.out.println(indent + prefix + root.val);

        if (root.left != null || root.right != null) {
            printTreeRec(root.left, level + 1, "L--- ");
            printTreeRec(root.right, level + 1, "R--- ");
        }
    }

    // MAIN METHOD TO TEST ALL OPERATIONS
    public static void main(String[] args) {
        CompleteBST bst = new CompleteBST();

        System.out.println("=== BINARY SEARCH TREE DEMO ===\n");

        // Insert values
        int[] values = {50, 30, 20, 40, 70, 60, 80, 15, 25, 35, 45, 65, 75, 85};
        System.out.println("Inserting values: " + java.util.Arrays.toString(values));

        for (int val : values) {
            bst.insert(val);
        }

        // Basic operations
        System.out.println("\n1. Tree Properties:");
        System.out.println("   Height: " + bst.height());
        System.out.println("   Total nodes: " + bst.countNodes());
        System.out.println("   Min value: " + bst.findMin());
        System.out.println("   Max value: " + bst.findMax());
        System.out.println("   Is valid BST: " + bst.isValidBST());

        // Traversals
        System.out.println("\n2. Tree Traversals:");
        System.out.print("   Inorder (Sorted): ");
        bst.inorder();
        System.out.print("   Preorder: ");
        bst.preorder();
        System.out.print("   Postorder: ");
        bst.postorder();

        // Search operations
        System.out.println("\n3. Search Operations:");
        System.out.println("   Search 40: " + bst.search(40));
        System.out.println("   Search 90: " + bst.search(90));

        // Kth smallest
        System.out.println("\n4. K-th Smallest Elements:");
        for (int k = 1; k <= 5; k++) {
            System.out.println("   " + k + "th smallest: " + bst.kthSmallest(k));
        }

        // LCA examples
        System.out.println("\n5. Lowest Common Ancestor (LCA):");
        System.out.println("   LCA of 20 and 40: " + bst.lca(20, 40));
        System.out.println("   LCA of 60 and 80: " + bst.lca(60, 80));
        System.out.println("   LCA of 25 and 45: " + bst.lca(25, 45));

        // Inorder successor
        System.out.println("\n6. Inorder Successors:");
        System.out.println("   Successor of 30: " + bst.inorderSuccessor(30));
        System.out.println("   Successor of 40: " + bst.inorderSuccessor(40));
        System.out.println("   Successor of 80: " + bst.inorderSuccessor(80));

        // Delete operations
        System.out.println("\n7. Delete Operations:");
        System.out.println("   Before deleting 30:");
        bst.printTree();

        bst.delete(30);
        System.out.println("\n   After deleting 30:");
        bst.printTree();

        bst.delete(70);
        System.out.println("\n   After deleting 70:");
        bst.printTree();

        System.out.println("\n   Inorder after deletions:");
        bst.inorder();
    }

    // Helper traversal methods for testing
    private void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.val + " ");
            inorderRec(root.right);
        }
    }

    private void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    private void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.val + " ");
        }
    }

    private boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return val < root.val ? searchRec(root.left, val) : searchRec(root.right, val);
    }
}
