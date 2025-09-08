package Trees.Binary_Tree.Day05_DegenerateOrSkewed_Binary_Tree;


/*
Right-Skewed Tree
Tree Structure

   5
    \
     15
       \
        25
          \
           35
             \
              45

 */


class Node3 {
    int data;
    Node3 left, right;

    Node3(int data) {
        this.data = data;
        left = right = null;
    }
}

public class RightSkewedTree2 {

    // Inorder Traversal
    static void inorder(Node3 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Preorder Traversal
    static void preorder(Node3 root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal
    static void postorder(Node3 root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        // Right-Skewed Tree Example
        Node3 root = new Node3(5);
        root.right = new Node3(15);
        root.right.right = new Node3(25);
        root.right.right.right = new Node3(35);
        root.right.right.right.right = new Node3(45);

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
5 15 25 35 45
Preorder:
5 15 25 35 45
Postorder:
45 35 25 15 5

Dry Run
Tree:
5 → 15 → 25 → 35 → 45

Traversals
Inorder (LNR): 5 15 25 35 45
Preorder (NLR): 5 15 25 35 45
Postorder (LRN): 45 35 25 15 5



Notice again:
In a Right-Skewed Tree, Inorder == Preorder.
Postorder prints elements reverse order.


 */
