package Trees.Binary_Tree.Balanced_Binary_Search_Trees;

public class Notes {
    public static void main(String[] args) {


        /*

1. Why We Need Balanced Trees
-----------------------------
A normal Binary Search Tree (BST) can become skewed (like a linked list) if data is sorted.
That means:
    Worst-case time: O(n)
    Best case (balanced): O(log n)
Goal of Balanced Trees:
Keep the height ≈ log₂(n) by rotating nodes when imbalance occurs.


2.AVL Tree — Height Balanced Tree
----------------------------------
Definition:
For every node in the tree,
    |height(left) - height(right)| ≤ 1

If the difference exceeds 1, the tree is unbalanced, and we perform rotations to fix it.


Balance Factor
--------------

BalanceFactor(node) = height(left) - height(right)

| Value     | Meaning                    |
| --------- | -------------------------- |
| 0         | Perfectly balanced         |
| 1         | Left-heavy                 |
| -1        | Right-heavy                |
| >1 or <-1 | Unbalanced → need rotation |


Types of Rotations
------------------

| Case | Condition      | Rotation              |
| ---- | -------------- | --------------------- |
| LL   | Left of Left   | Right Rotation        |
| RR   | Right of Right | Left Rotation         |
| LR   | Left of Right  | Left + Right Rotation |
| RL   | Right of Left  | Right + Left Rotation |


Example: LL Rotation
Before inserting, the tree becomes left-heavy.

After Right Rotation around 30:
     20
    /  \
   10   30
Tree balanced again.

Java Code — AVL Tree Insertion with Rotations

class AVLNode {
    int key, height;
    AVLNode left, right;
    AVLNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

class AVLTree {
    AVLNode root;

    int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    AVLNode insert(AVLNode node, int key) {
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // duplicates not allowed

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check balance
        int balance = getBalance(node);

        // 4 cases
        if (balance > 1 && key < node.left.key)
            return rightRotate(node); // LL
        if (balance < -1 && key > node.right.key)
            return leftRotate(node); // RR
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node); // LR
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node); // RL
        }

        return node;
    }

    void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}


Test it

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] values = {10, 20, 30, 40, 50, 25};

        for (int val : values)
            tree.root = tree.insert(tree.root, val);

        System.out.print("Preorder traversal: ");
        tree.preOrder(tree.root);
    }
}

Output:
Preorder traversal: 30 20 10 25 40 50

Balanced automatically after insertions!




3.Red-Black Tree — Color Balanced Tree
--------------------------------------

A Red-Black Tree is a BST that keeps itself balanced using color properties instead of
strict height balancing like AVL.

Properties
----------
    1.Every node is either Red or Black
    2.Root is always Black
    3.All leaves (NIL) are Black
    4.Red node cannot have a Red child
    5.Every path from root to leaf has same number of Black nodes


Rebalancing Rules
-----------------
When you insert:
    If parent is Black →  nothing to fix
    If parent is Red →  fix using recoloring or rotations


AVL vs Red-BlackAVL vs Red-Black

| Feature       | AVL           | Red-Black       |
| ------------- | ------------- | --------------- |
| Balance type  | Height-based  | Color-based     |
| Rotations     | More frequent | Fewer           |
| Search        | Faster        | Slightly slower |
| Insert/Delete | Slower        | Faster          |
| Use Case      | Read-heavy    | Write-heavy     |



1.Recap: Why Red-Black Tree?
----------------------------
In AVL Tree, the balancing is very strict (height difference ≤ 1).
That gives faster searches but slower insertions/deletions.

Red-Black Tree relaxes the rule slightly:

It guarantees height is at most 2 × log₂(n).
That keeps operations efficient O(log n) while needing fewer rotations.


2.Red-Black Tree — Key Rules (Must Memorize)
--------------------------------------------
1 Every node is either Red or Black
2 Root is always Black
3 Leaf nodes (NIL) are Black
4 If a node is Red, its children must be Black (no two Reds in a row)
5 Every path from a node to its descendant NIL leaves has the same number of Black nodes


3.Insert Operation Logic
-------------------------
When inserting a node, it starts as Red (to not violate property #5).
Then you check and fix any rule violations using:
    Recoloring
    Rotations

Common Fix Cases

| Case | Parent | Uncle | Fix                                               |
| ---- | ------ | ----- | ------------------------------------------------- |
| 1    | Red    | Red   | Recolor parent + uncle → black, grandparent → red |
| 2    | Red    | Black | Perform **rotation** (Left/Right) + Recolor       |
| 3    | Root   | —     | Just color root Black                             |

Example Flow

Insert sequence: 10, 20, 30

Insert 10 → root, make it Black

10(B)

Insert 20 → Red (no violation)

   10(B)
       \
       20(R)

Insert 30 → Red
Parent (20) and node (30) both red  → Violation
Perform Left Rotation around 10 and recolor:

      20(B)
     /   \
  10(R)  30(R)

Balanced!

4. Java Implementation (Simplified Version)
-------------------------------------------

class Node {
    int data;
    Node left, right, parent;
    boolean color; // true = RED, false = BLACK

    Node(int data) {
        this.data = data;
        this.color = true; // new nodes are RED
    }
}

class RedBlackTree {
    private Node root;

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null)
            y.left.parent = x;

        y.parent = x.parent;

        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null)
            x.right.parent = y;

        x.parent = y.parent;

        if (y.parent == null)
            root = x;
        else if (y == y.parent.left)
            y.parent.left = x;
        else
            y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    private void fixViolation(Node node) {
        Node parent = null;
        Node grandparent = null;

        while (node != root && node.color && node.parent.color) {
            parent = node.parent;
            grandparent = parent.parent;

            // Case A: Parent is left child of grandparent
            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Case 1: Uncle is red (recolor)
                if (uncle != null && uncle.color) {
                    grandparent.color = true;
                    parent.color = false;
                    uncle.color = false;
                    node = grandparent;
                } else {
                    // Case 2: node is right child -> rotate left
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    // Case 3: rotate right
                    rotateRight(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            } else { // Mirror cases
                Node uncle = grandparent.left;
                if (uncle != null && uncle.color) {
                    grandparent.color = true;
                    parent.color = false;
                    uncle.color = false;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    rotateLeft(grandparent);
                    boolean temp = parent.color;
                    parent.color = grandparent.color;
                    grandparent.color = temp;
                    node = parent;
                }
            }
        }
        root.color = false; // root always black
    }

    public void insert(int data) {
        Node node = new Node(data);
        root = bstInsert(root, node);
        fixViolation(node);
    }

    private Node bstInsert(Node root, Node node) {
        if (root == null)
            return node;

        if (node.data < root.data) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.data > root.data) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(Node root) {
        if (root != null) {
            inorderHelper(root.left);
            System.out.print(root.data + (root.color ? "(R) " : "(B) "));
            inorderHelper(root.right);
        }
    }
}

Test Code

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        int[] values = {10, 20, 30, 15, 25, 5};

        for (int v : values)
            tree.insert(v);

        System.out.println("Inorder traversal with colors:");
        tree.inorder();
    }
}

Sample Output:

5(R) 10(B) 15(R) 20(B) 25(R) 30(B)

Balanced BST maintained with fewer rotations.

Real-world Usage

| Use Case                | Structure      |
| ----------------------- | -------------- |
| Java TreeMap / TreeSet  | Red-Black Tree |
| Linux Process Scheduler | Red-Black Tree |
| C++ std::map / std::set | Red-Black Tree |


         */
    }
}
