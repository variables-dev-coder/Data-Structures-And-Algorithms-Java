package Trees.Binary_Tree.Useful_Problems_Patterns;

/*
Problem 1: Lowest Common Ancestor (LCA)
Definition
In a binary tree, the Lowest Common Ancestor (LCA) of two given nodes p and q
is the lowest node that has both p and q as descendants.
(We allow a node to be a descendant of itself.)

Intuition
traverse the tree recursively.
For each node:
    If the node itself is null → return null.
    If the node is p or q → return that node (potential match).
    Recur to left and right subtrees.
    If both sides return non-null → this node is the LCA.
    If only one side is non-null → pass that up.
 */

class Node1 {
    int val;
    Node1 left, right;

    Node1(int v) { val = v; }
}

class BinaryTreeLCA {
    Node1 lowestCommonAncestor(Node1 root, Node1 p, Node1 q) {
        if (root == null || root == p || root == q)
            return root;

        Node1 left = lowestCommonAncestor(root.left, p, q);
        Node1 right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root; // Found split point

        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        Node1 root = new Node1(3);
        root.left = new Node1(5);
        root.right = new Node1(1);
        root.left.left = new Node1(6);
        root.left.right = new Node1(2);
        root.right.left = new Node1(0);
        root.right.right = new Node1(8);
        root.left.right.left = new Node1(7);
        root.left.right.right = new Node1(4);

        BinaryTreeLCA bt = new BinaryTreeLCA();
        Node1 lca = bt.lowestCommonAncestor(root, root.left, root.left.right.right); // LCA(5,4)
        System.out.println("LCA of 5 and 4 = " + lca.val);
    }
}

/*
Output:
LCA of 5 and 4 = 5

Tree:
        3
       / \
      5   1
     / \  / \
    6  2 0  8
      / \
     7  4

Find LCA(5,4):

1 Start at root (3)
→ Not equal to 5 or 4
→ Search left (5), right (1)

2 Left subtree (5):
→ root == p (5)  → return (5)

3 Right subtree (1):
→ does not contain 4 → returns null

Now, back to (3):
→ left = (5), right = null → return left (5)

 LCA = 5

 Complexity

 | Type  | Value                                   |
| ----- | --------------------------------------- |
| Time  | O(n) – visits each node once            |
| Space | O(h) – recursion depth (height of tree) |


 */