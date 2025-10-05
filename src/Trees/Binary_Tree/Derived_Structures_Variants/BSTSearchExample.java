package Trees.Binary_Tree.Derived_Structures_Variants;


/*
Search Operation in a Binary Search Tree (BST)
    Builds a BST (using insertion)
    Searches for a given key
    Prints whether the key exists or not
 */

class BSTNode1 {
    int val;
    BSTNode1 left, right;

    BSTNode1(int val) {
        this.val = val;
    }
}

public class BSTSearchExample {
    BSTNode1 root;

    // Insert method (same as before)
    BSTNode1 insert(BSTNode1 root, int val) {
        if (root == null)
            return new BSTNode1(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else if (val > root.val)
            root.right = insert(root.right, val);

        return root;
    }

    // Recursive Search
    boolean searchRecursive(BSTNode1 root, int key) {
        if (root == null)
            return false;
        if (root.val == key)
            return true;
        if (key < root.val)
            return searchRecursive(root.left, key);
        else
            return searchRecursive(root.right, key);
    }

    // Iterative Search
    boolean searchIterative(BSTNode1 root, int key) {
        while (root != null) {
            if (key == root.val)
                return true;
            else if (key < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }

    public static void main(String[] args) {
        BSTSearchExample bst = new BSTSearchExample();
        int[] values = { 8, 3, 10, 1, 6, 14, 4, 7, 13 };

        for (int val : values)
            bst.root = bst.insert(bst.root, val);

        int key1 = 7;
        int key2 = 11;

        System.out.println("Search Recursive (key=" + key1 + "): " + bst.searchRecursive(bst.root, key1));
        System.out.println("Search Recursive (key=" + key2 + "): " + bst.searchRecursive(bst.root, key2));

        System.out.println("Search Iterative (key=" + key1 + "): " + bst.searchIterative(bst.root, key1));
        System.out.println("Search Iterative (key=" + key2 + "): " + bst.searchIterative(bst.root, key2));
    }
}

/*
Search Recursive (key=7): true
Search Recursive (key=11): false
Search Iterative (key=7): true
Search Iterative (key=11): false

Explanation:

Recursive logic:
    Base case → if root == null → not found
    If root.val == key → found
    If key < root.val → search left
    Else → search right

Iterative logic:
    Move down the tree without recursion
    Update current node pointer until found or null

Complexity:
    Time: O(h) → average O(log n), worst O(n)
    Space:
        Recursive → O(h)
        Iterative → O(1)


 */