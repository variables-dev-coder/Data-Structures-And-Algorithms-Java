package Trees.Binary_Search_Tree_BST.Day2_Searching_in_BST;

public class Notes {
    public static void main(String[] args) {

        /*

Searching in Binary Search Tree (BST)
-------------------------------------

1. Concept: How Search Works
    In a BST, search works using its ordering property:

For every node:
 All values in the left subtree < node’s key
 All values in the right subtree > node’s key

So searching becomes a decision-making process at every node:

If key = root →  Found

If key < root →  Move left

If key > root →  Move right

This process eliminates half of the remaining nodes at each step (like binary search on arrays).


2. Step-by-Step Search Logic

search(node, key):
    if node == null → not found
    if node.key == key → found
    if key < node.key → search left subtree
    else → search right subtree

3. Visual Example

Let’s use this tree:

        50
       /  \
     30    70
    / \    / \
  20  40  60  80

Search for 40:

Start at 50 → 40 < 50 → go left
Now 30 → 40 > 30 → go right
Now 40 → found

Search for 65:

Start at 50 → 65 > 50 → go right
Now 70 → 65 < 70 → go left
Now 60 → 65 > 60 → go right
Now null → not found


4. Recursive Implementation

class BinarySearchTree {
    Node root;

    // Recursive Search
    Node search(Node root, int key) {
        // Base case
        if (root == null || root.key == key)
            return root;

        // Go left or right based on value
        if (key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        int key = 40;
        Node result = tree.search(tree.root, key);
        if (result != null)
            System.out.println("Key " + key + " found!");
        else
            System.out.println("Key " + key + " not found!");
    }
}



5. Iterative Implementation

This version avoids recursion and uses a loop:

Node searchIterative(Node root, int key) {
    while (root != null) {
        if (key == root.key)
            return root;
        else if (key < root.key)
            root = root.left;
        else
            root = root.right;
    }
    return null; // not found
}

Works same as recursive
Slightly faster (no recursive call stack)



6. Time Complexity

| Case             | Description                      | Time Complexity |
| ---------------- | -------------------------------- | --------------- |
| **Best Case**    | Element found at root            | O(1)            |
| **Average Case** | Tree balanced                    | O(log n)        |
| **Worst Case**   | Skewed tree (like a linked list) | O(n)            |


7. Space Complexity

| Version   | Space                               |
| --------- | ----------------------------------- |
| Recursive | O(h) → call stack (h = tree height) |
| Iterative | O(1)                                |


8. Dry Run (Example)

Let’s dry-run search for 70:

| Step | Node | Comparison | Move     |
| ---- | ---- | ---------- | -------- |
| 1    | 50   | 70 > 50    | Go Right |
| 2    | 70   | 70 == 70   | Found   |

Output: Key 70 found!


9. Real-world Analogy

Think of a phone directory:

You look for “Ravi”.
Start from middle page “M”.
    Since “R” comes after “M”, go right.
    Next letter comparison narrows down faster.
That’s exactly what BST search does — divide and rule efficiently.


         */
    }
}
