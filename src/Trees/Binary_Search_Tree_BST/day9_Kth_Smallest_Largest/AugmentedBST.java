package Trees.Binary_Search_Tree_BST.day9_Kth_Smallest_Largest;

/*
Augmented BST (best for repeated queries)
If you need many kth queries, augment each node with size = number of nodes in subtree.
Idea (per node):
leftSize = size(root.left)
If k == leftSize + 1 → root is kth smallest
If k ≤ leftSize → go left
else → go right with k = k - leftSize - 1
This gives O(h) per query.
Runnable skeleton (augmentation & kth smallest O(h)):
 */


public class AugmentedBST {
    static class Node {
        int val;
        Node left, right;
        int size; // size of subtree including this node
        Node(int v){ val = v; size = 1; }
    }

    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        root.size = 1 + size(root.left) + size(root.right);
        return root;
    }

    static int size(Node n) { return n == null ? 0 : n.size; }

    static int kthSmallest(Node root, int k) {
        if (root == null) throw new IllegalArgumentException("k invalid");
        int leftSize = size(root.left);
        if (k == leftSize + 1) return root.val;
        if (k <= leftSize) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - leftSize - 1);
    }

    public static void main(String[] args) {
        int[] vals = {50,30,70,20,40,60,80};
        Node root = null;
        for (int v : vals) root = insert(root, v);
        System.out.println("3rd smallest = " + kthSmallest(root, 3)); // 40
        System.out.println("2nd largest = " + kthSmallest(root, 6)); // 70  (6th smallest == 2nd largest)
    }
}

//3rd smallest = 40
//2nd largest = 70

//Note: Maintaining sizes on deletes/rotations is needed if tree changes