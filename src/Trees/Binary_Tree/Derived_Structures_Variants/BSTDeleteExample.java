package Trees.Binary_Tree.Derived_Structures_Variants;

/*
Delete Node in BST
Concept Recap

When deleting a node from a BST, there are 3 cases:

Node has no child (Leaf node) → just delete it.
Node has one child → replace the node with its child.
Node has two children →

    Find inorder successor (smallest node in the right subtree).
    Replace node’s value with the successor’s value.
    Delete the successor node from the right subtree.

 */

class BSTNode2 {
    int val;
    BSTNode2 left, right;

    BSTNode2(int val) {
        this.val = val;
    }
}

public class BSTDeleteExample {
    BSTNode2 root;

    // Insert a new value in BST
    BSTNode2 insert(BSTNode2 root, int val) {
        if (root == null)
            return new BSTNode2(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }

    // Find the minimum value node in a BST
    BSTNode2 findMin(BSTNode2 root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Delete a node in BST
    BSTNode2 delete(BSTNode2 root, int key) {
        if (root == null)
            return null;

        // Step 1: Traverse to the node
        if (key < root.val)
            root.left = delete(root.left, key);
        else if (key > root.val)
            root.right = delete(root.right, key);
        else {
            // Step 2: Node found – handle the 3 cases

            // Case 1: No child
            if (root.left == null && root.right == null)
                return null;

                // Case 2: One child
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 3: Two children
            BSTNode2 minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = delete(root.right, minNode.val);
        }

        return root;
    }

    // Inorder Traversal (sorted output)
    void inorder(BSTNode2 root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        BSTDeleteExample bst = new BSTDeleteExample();
        int[] values = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

        for (int val : values)
            bst.root = bst.insert(bst.root, val);

        System.out.print("Original BST (Inorder): ");
        bst.inorder(bst.root);

        System.out.println("\n\nDeleting leaf node 1...");
        bst.root = bst.delete(bst.root, 1);
        bst.inorder(bst.root);

        System.out.println("\n\nDeleting node with one child 14...");
        bst.root = bst.delete(bst.root, 14);
        bst.inorder(bst.root);

        System.out.println("\n\nDeleting node with two children 3...");
        bst.root = bst.delete(bst.root, 3);
        bst.inorder(bst.root);
    }
}

/*
Original BST (Inorder): 1 3 4 6 7 8 10 13 14

Deleting leaf node 1...
3 4 6 7 8 10 13 14

Deleting node with one child 14...
3 4 6 7 8 10 13

Deleting node with two children 3...
4 6 7 8 10 13


Dry Run

Let’s dry run for deleting node 3:

Initial Inorder:
1 3 4 6 7 8 10 13 14

Node 3 has two children (1 and 6).

Find inorder successor = 4 (smallest in right subtree).

Replace 3 → 4.

Delete node 4 from right subtree.

After deletion:
1 4 6 7 8 10 13 14

Complexity
Time: O(h) → average O(log n), worst O(n)
Space: O(h) for recursion


 */