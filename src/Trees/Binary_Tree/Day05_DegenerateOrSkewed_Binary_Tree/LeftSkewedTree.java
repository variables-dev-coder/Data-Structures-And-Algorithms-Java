package Trees.Binary_Tree.Day05_DegenerateOrSkewed_Binary_Tree;



// Left-Skewed Tree

/*
Tree Structure

       50
      /
     40
    /
   30
  /
 20
/
10

 */
class Node2 {
    int data;
    Node2 left, right;

    Node2(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LeftSkewedTree {

    // Inorder Traversal
    static void inorder(Node2 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    static void preorder(Node2 root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    static void postorder(Node2 root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Left-Skewed Tree Example
        Node2 root = new Node2(50);
        root.left = new Node2(40);
        root.left.left = new Node2(30);
        root.left.left.left = new Node2(20);
        root.left.left.left.left = new Node2(10);

        System.out.println("Inorder:");
        inorder(root);
        System.out.println("\nPreorder:");
        preorder(root);
        System.out.println("\nPostorder:");
        postorder(root);
    }
}

/*
Inorder:
10 20 30 40 50
Preorder:
50 40 30 20 10
Postorder:
10 20 30 40 50


Dry Run
Tree:

50
 |
 40
 |
 30
 |
 20
 |
 10

Traversals
Inorder (LNR): 10 20 30 40 50
Preorder (NLR): 50 40 30 20 10
Postorder (LRN): 10 20 30 40 50


Notice the mirror effect compared to Right-Skewed Tree:
In Right-Skewed, Inorder == Preorder
In Left-Skewed, Inorder == Postorder


 */