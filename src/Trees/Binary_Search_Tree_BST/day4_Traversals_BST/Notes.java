package Trees.Binary_Search_Tree_BST.day4_Traversals_BST;

public class Notes {
    public static void main(String[] args) {


/*

What Traversals Mean
---------------------

A traversal is simply the order in which you visit nodes in a tree.

BST = Binary Tree with ordering property.
Traversal = visiting nodes in a structured pattern.



===============================================================================================


The 4 Major Traversals
----------------------
1.Inorder (L-N-R)
2.Preorder (N-L-R)
3.Postorder (L-R-N)
4.Level Order (BFS)

Let’s master them using one fixed BST:

        50
       /  \
     30    70
    / \    / \
   20 40  60 80

1. Inorder Traversal (L → N → R)
--------------------------------

For BST: this gives sorted order → ALWAYS!
    Visit left subtree
    Visit node
    Visit right subtree

Why sorted?
-----------
Because in BST:

All left subtree values < node < all right subtree values

And inorder visits nodes in that exact hierarchy.

Output:

20 30 40 50 60 70 80

2. Preorder Traversal (N → L → R)
---------------------------------

Used for:
creating tree
prefix expressions
copying tree

Output:

50 30 20 40 70 60 80

3. Postorder Traversal (L → R → N)
----------------------------------

Used for:
deleting tree bottom-up
postfix evaluation
freeing memory

Output:

20 40 30 60 80 70 50

4. Level Order (Breadth-First Search)
-------------------------------------

Visit left → right level by level.

Output:

50 30 70 20 40 60 80

Queue is used internally.


Master-Level Java Implementation
=================================

class Node {
    int key;
    Node left, right;
    Node(int k) { key = k; }
}

class BST {

    // 1. Inorder: L N R
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // 2. Preorder: N L R
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // 3. Postorder: L R N
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // 4. Level Order (BFS)
    void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.key + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
}

Quick Recall Table (Super Useful for Interviews)

| Traversal       | Order          | Use Case                    |
| --------------- | -------------- | --------------------------- |
| **Inorder**     | L → N → R      | Sorted output from BST      |
| **Preorder**    | N → L → R      | Build tree, prefix          |
| **Postorder**   | L → R → N      | Memory deletion, postfix    |
| **Level Order** | Level by level | BFS, shortest path in trees |




 */
    }
}
