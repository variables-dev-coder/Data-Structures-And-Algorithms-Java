package Trees.Binary_Tree.Day05_DegenerateOrSkewed_Binary_Tree;

public class Notes {
    public static void main(String[] args) {
        /*

Degenerate / Skewed Binary Tree
-------------------------------
    Concept (Simple Words)
    A Degenerate Binary Tree is where every parent node has only one child.
    It looks like a linked list instead of a tree.

Two main types:
Left-Skewed → all children on left
Right-Skewed → all children on right

Height = number of nodes
Worst-case performance (O(n)) same as Linked Lis


Example
Left-Skewed:

    10
   /
  8
 /
6
/
4


Right-Skewed:

10
  \
   12
     \
      14
        \
         16


Java Example with Traversals

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class DegenerateTree {

    // Inorder Traversal
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Example: Right-Skewed Tree
        Node root = new Node(10);
        root.right = new Node(20);
        root.right.right = new Node(30);
        root.right.right.right = new Node(40);

        System.out.println("Inorder:");
        inorder(root);
        System.out.println("\nPreorder:");
        preorder(root);
        System.out.println("\nPostorder:");
        postorder(root);
    }
}


Dry Run (Right-Skewed Tree)
Tree:
10 → 20 → 30 → 40

Inorder (LNR): 10 20 30 40
Preorder (NLR): 10 20 30 40
Postorder (LRN): 40 30 20 10
Notice: In Skewed Trees, traversal looks like Linked List traversal.



         */
    }
}
