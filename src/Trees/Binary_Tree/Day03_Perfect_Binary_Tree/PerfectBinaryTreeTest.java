package Trees.Binary_Tree.Day03_Perfect_Binary_Tree;

//Non-Perfect Binary Tree Example

public class PerfectBinaryTreeTest {
    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   /
            4   5 6
        */


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        // Notice: right child of node 3 is missing

        int depth = PerfectBinaryTree.findDepth(root);
        if (PerfectBinaryTree.isPerfect(root, depth, 0))
            System.out.println("Tree is Perfect Binary Tree");
        else
            System.out.println("Tree is NOT Perfect Binary Tree");
    }

}

/*
Tree is NOT Perfect Binary Tree

Dry Run
        1
      /   \
     2     3
    / \   /
   4  5  6


1. findDepth()
    Leftmost path = 1 → 2 → 4 → depth = 3.
2. isPerfect(root, depth, 0) →
    Node(1): ok (2 children).
    Node(2): ok (2 children).
    Node(3):  only 1 child (left=6, right=null).
Since a Perfect Binary Tree requires every internal node to have exactly 2 children, this condition fails.

Output → Tree is NOT Perfect Binary Tree


So difference is clear:
Perfect → every level completely filled, all leaves at same depth.
Non-Perfect → even if only one child is missing → fails.


 */