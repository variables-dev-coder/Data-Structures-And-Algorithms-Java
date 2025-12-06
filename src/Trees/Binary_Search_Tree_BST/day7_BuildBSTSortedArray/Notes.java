package Trees.Binary_Search_Tree_BST.day7_BuildBSTSortedArray;

public class Notes {
    public static void main(String[] args) {

        /*
Day 7 – Build BST from Sorted Array (Balanced BST)
==================================================
Goal: Convert a sorted array into a balanced Binary Search Tree (BST).
Balanced BST = height ≈ log(N) → fast search, fast insert/delete.

1. Why Sorted Array → Balanced BST?
-----------------------------------
If array = [10, 20, 30, 40, 50, 60, 70]

We want this shape:

        40
       /  \
     20    60
    / \    / \
   10 30  50 70


Perfectly balanced.

Why?
    BST operations become:
    Search → O(log n)
    Insert → O(log n)
    Delete → O(log n)

If you insert sorted numbers normally
→ you get a skewed tree (linked-list shape) → O(n) → BAD.

So we build balanced BST manually using divide & conquer.


2. Core Logic (Mastery Logic)
-----------------------------
Choose the middle element → root
Recursively build:
    left subtree from left half
    right subtree from right half


3. Recurrence (Think like an interviewer)
-----------------------------------------
mid = (l + r) / 2

root = new Node(arr[mid])

root.left  = build(arr, l, mid-1)
root.right = build(arr, mid+1, r)


4. Dry Run Example
------------------
Array:
[10, 20, 30, 40, 50, 60, 70]

Step-by-step:
    1. mid = 3 → 40 → root
    2. Left array = [10, 20, 30]
       mid = 1 → 20 → root.left

    3. Right array = [50, 60, 70]
       mid = 5 → 60 → root.right

And recursively continues.


5. Runnable Code (Java)
-----------------------

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
    }
}

public class SortedArrayToBST {

    static Node buildBST(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);

        root.left = buildBST(arr, start, mid - 1);
        root.right = buildBST(arr, mid + 1, end);

        return root;
    }

    // INORDER → should print sorted array again
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        Node root = buildBST(arr, 0, arr.length - 1);

        System.out.println("Inorder (sorted):");
        inorder(root);
    }
}


6. Why Balanced BST Matters?
----------------------------
    Faster search
    Used in database indexing
    Used in TreeMap & TreeSet (Java)
    Forms base for AVL Trees, Red-Black Trees
    Helps in producing optimal search cost

Day 7 Achievement

Today you mastered:
Balanced BST construction
Divide & conquer tree building
Why middle element gives perfect balance
Validated using inorder traversal
This is a must-know interview pattern.


         */
    }
}
