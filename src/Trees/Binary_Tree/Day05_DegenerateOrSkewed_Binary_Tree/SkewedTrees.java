package Trees.Binary_Tree.Day05_DegenerateOrSkewed_Binary_Tree;

/*
Left-Skewed vs Right-Skewed Binary Tree
Left-Skewed Tree

      50
     /
   40
   /
 30
 /
20
/
10

Right-Skewed Tree

10
  \
   20
     \
      30
        \
         40
           \
            50

 */


class Node4 {
    int data;
    Node4 left, right;

    Node4(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SkewedTrees {

    // Inorder Traversal (LNR)
    static void inorder(Node4 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal (NLR)
    static void preorder(Node4 root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal (LRN)
    static void postorder(Node4 root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Left-Skewed Tree
        Node4 leftRoot = new Node4(50);
        leftRoot.left = new Node4(40);
        leftRoot.left.left = new Node4(30);
        leftRoot.left.left.left = new Node4(20);
        leftRoot.left.left.left.left = new Node4(10);

        // Right-Skewed Tree
        Node4 rightRoot = new Node4(10);
        rightRoot.right = new Node4(20);
        rightRoot.right.right = new Node4(30);
        rightRoot.right.right.right = new Node4(40);
        rightRoot.right.right.right.right = new Node4(50);

        System.out.println("=== Left-Skewed Tree Traversals ===");
        System.out.print("Inorder: ");
        inorder(leftRoot);
        System.out.print("\nPreorder: ");
        preorder(leftRoot);
        System.out.print("\nPostorder: ");
        postorder(leftRoot);

        System.out.println("\n\n=== Right-Skewed Tree Traversals ===");
        System.out.print("Inorder: ");
        inorder(rightRoot);
        System.out.print("\nPreorder: ");
        preorder(rightRoot);
        System.out.print("\nPostorder: ");
        postorder(rightRoot);
    }
}

/*
=== Left-Skewed Tree Traversals ===
Inorder: 10 20 30 40 50
Preorder: 50 40 30 20 10
Postorder: 10 20 30 40 50

=== Right-Skewed Tree Traversals ===
Inorder: 10 20 30 40 50
Preorder: 10 20 30 40 50
Postorder: 50 40 30 20 10


Dry Run Results

Left-Skewed Tree
Inorder (LNR): 10 20 30 40 50
Preorder (NLR): 50 40 30 20 10
Postorder (LRN): 10 20 30 40 50

Right-Skewed Tree
Inorder (LNR): 10 20 30 40 50
Preorder (NLR): 10 20 30 40 50
Postorder (LRN): 50 40 30 20 10


Key Observations:
Inorder for both skewed trees = sorted order (10 → 50).
Preorder & Postorder are mirror images between Left-Skewed and Right-Skewed.

 */