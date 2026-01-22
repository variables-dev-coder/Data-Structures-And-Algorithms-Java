package Trees.Binary_Search_Tree_BST.revision2;

// TreeNode.java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// BasicBST.java
public class BasicBST {
    private TreeNode root;

    public BasicBST() {
        root = null;
    }

    // 1. INSERT A NODE
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

    // 2. SEARCH FOR A NODE
    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(TreeNode root, int val) {
        if (root == null) {
            return false;
        }

        if (root.val == val) {
            return true;
        }

        if (val < root.val) {
            return searchRec(root.left, val);
        } else {
            return searchRec(root.right, val);
        }
    }

    // 3. INORDER TRAVERSAL (Sorted Order)
    public void inorder() {
        System.out.print("Inorder (Sorted): ");
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

    // 4. PREORDER TRAVERSAL
    public void preorder() {
        System.out.print("Preorder: ");
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

    // 5. POSTORDER TRAVERSAL
    public void postorder() {
        System.out.print("Postorder: ");
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

    // 6. LEVEL ORDER TRAVERSAL (BFS)
    public void levelOrder() {
        if (root == null) return;

        System.out.print("Level Order: ");
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        BasicBST bst = new BasicBST();

        // Insert values
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        System.out.println("Inserting: " + java.util.Arrays.toString(values));

        for (int val : values) {
            bst.insert(val);
        }

        // Traversals
        bst.inorder();
        bst.preorder();
        bst.postorder();
        bst.levelOrder();

        // Search
        System.out.println("\nSearch Results:");
        System.out.println("Search 40: " + bst.search(40)); // true
        System.out.println("Search 90: " + bst.search(90)); // false

        // Visual representation
        System.out.println("\nTree Structure:");
        System.out.println("       50");
        System.out.println("     /    \\");
        System.out.println("    30     70");
        System.out.println("   /  \\   /  \\");
        System.out.println("  20  40 60  80");
    }
}
