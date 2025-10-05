package Trees.Binary_Tree.Derived_Structures_Variants;

// Basic BST – Insert and Inorder Traversal (Sorted Order)

class BSTNode {
    int val;
    BSTNode left, right;

    BSTNode(int val) {
        this.val = val;
    }
}

public class BSTExample1 {
    BSTNode root;

    // Insert a new value into BST
    BSTNode insert(BSTNode root, int val) {
        if (root == null)
            return new BSTNode(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }

    // Inorder traversal (Left → Root → Right)
    void inorder(BSTNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BSTExample1 bst = new BSTExample1();
        int[] values = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

        for (int val : values)
            bst.root = bst.insert(bst.root, val);

        System.out.println("Inorder Traversal (Sorted Order): ");
        bst.inorder(bst.root);
    }
}

// Inorder Traversal (Sorted Order):
//1 3 4 6 7 8 10 13 14

/*

Explanation:
    BST Property:
        For each node:
        Left subtree → smaller values
    Right subtree → larger values
    Inorder traversal always prints BST in sorted order.

Dry Run (insert sequence):
    Insert 8 → root = 8
    Insert 3 → goes to left of 8
    Insert 10 → right of 8
    Insert 1 → left of 3
    Insert 6 → right of 3
    Insert 14 → right of 10
    Insert 4 → left of 6
    Insert 7 → right of 6
    Insert 13 → left of 14

Final BST:

        8
       / \
      3   10
     / \    \
    1   6    14
       / \   /
      4   7 13


 */