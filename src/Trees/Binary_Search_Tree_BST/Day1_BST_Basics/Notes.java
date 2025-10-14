package Trees.Binary_Search_Tree_BST.Day1_BST_Basics;

public class Notes {
    public static void main(String[] args) {

        /*

1.What is a Binary Search Tree (BST)?
------------------------------------
A Binary Search Tree (BST) is a special type of Binary Tree that maintains a specific ordering rule:

For every node:
    All keys in the left subtree are smaller than the node’s key.
    All keys in the right subtree are greater than the node’s key.

This property ensures fast search, insertion, and deletion (ideally O(log n)) — just
like how binary search works on sorted arrays.


Intuition:
-----------
Think of BST as a “sorted hierarchy” —
Every node acts like a decision point:
    Go left for smaller values
    Go right for larger values

This creates a structure that behaves like a “tree-shaped binary search”.



2.Properties and Rules of BST
-----------------------------

| Property                   | Description                                                                                |
| -------------------------- | ------------------------------------------------------------------------------------------ |
| **Ordering Property**      | Left < Root < Right                                                                        |
| **Unique Keys (optional)** | Usually BST stores unique keys (duplicates can be handled with rules like “equal → right”) |
| **Recursive Structure**    | Each subtree is itself a BST                                                               |
| **Traversal**              | Inorder traversal of BST gives **sorted order** of elements                                |
| **Height**                 | Height determines efficiency; balanced → O(log n), skewed → O(n)                           |




3.Difference: Binary Tree vs Binary Search Tree
------------------------------------------------

| Feature              | Binary Tree                                                   | Binary Search Tree                                             |
| -------------------- | ------------------------------------------------------------- | -------------------------------------------------------------- |
| **Definition**       | Hierarchical structure with nodes (each node has ≤2 children) | A Binary Tree with the ordering property (Left < Root < Right) |
| **Ordering**         | No rule for order                                             | Strict ordering rule                                           |
| **Searching**        | Linear (O(n))                                                 | Logarithmic (O(log n)) if balanced                             |
| **Traversal Output** | Any order                                                     | Inorder traversal → Sorted                                     |
| **Examples**         | Family tree, file directory                                   | Map, Database index, Range queries                             |





4.Real-world Use Cases of BST
-----------------------------

| Application                     | Explanation                                                      |
| ------------------------------- | ---------------------------------------------------------------- |
| **Databases**                   | Used in indexing and query optimization                          |
| **File Systems**                | Organize hierarchical data (file/directory access)               |
| **Search Engines**              | Ranking or keyword indexing                                      |
| **Memory Management**           | To allocate/deallocate blocks efficiently                        |
| **Auto-complete / Spell-check** | Used with variants like prefix trees or balanced BSTs            |
| **Java TreeMap & TreeSet**      | Internally implemented using self-balancing BST (Red-Black Tree) |



5.BST Structure and Manual Node Creation
-----------------------------------------

Let’s first create the base class structure.

// Node.java
class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

Each node stores:
    key → the data value
    left → link to smaller elements
    right → link to larger elements



6.Building BST from Scratch (Insert Logic)
-------------------------------------------

We’ll now create the BST class and implement the insert operation manually.

Logic (step-by-step):
    1.If tree is empty, create a new node and make it root.
    2.If key < root.key → go left subtree
    3.If key > root.key → go right subtree
    4.Continue recursively until correct position is found.

Recursive Nature:

Each recursive call is responsible for finding the correct place for the key in its own subtree.



Code

// BST.java
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert method (public)
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive insert function
    Node insertRec(Node root, int key) {
        // Base case: if tree/subtree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Recursive case: decide to go left or right
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // return unchanged node pointer
        return root;
    }

    // Inorder traversal to verify sorted property
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes manually
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal (sorted): ");
        tree.inorder();
    }
}

Dry Run Example

Insert order: 50, 30, 70, 20, 40, 60, 80

Step 1:
Insert 50 → Tree empty → make root = 50

Step 2:
Insert 30 → 30 < 50 → goes to left of 50

Step 3:
Insert 70 → 70 > 50 → goes to right of 50

Step 4:
Insert 20 → 20 < 50 → go left → 20 < 30 → goes to left of 30

Step 5:
Insert 40 → 40 < 50 → go left → 40 > 30 → goes to right of 30

And so on.

Final Tree Structure:

        50
       /  \
     30    70
    / \    / \
  20  40  60  80


Inorder traversal: 20 30 40 50 60 70 80  (Sorted)


Complexity

| Operation | Time (Avg) | Time (Worst – Skewed) |
| --------- | ---------- | --------------------- |
| Insert    | O(log n)   | O(n)                  |
| Search    | O(log n)   | O(n)                  |
| Delete    | O(log n)   | O(n)                  |



Goal Achieved

Understood BST rules & structure
Understood how insertion logic works
Built complete BST manually in Java
Verified sorted property using inorder traversal


         */
    }
}
