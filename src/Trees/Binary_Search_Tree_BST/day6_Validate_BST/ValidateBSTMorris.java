package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*
Validate BST Using Morris Inorder Traversal (O(1) Space)

(Master-level problem — asked in senior interviews)

Concept

Morris traversal allows you to do an inorder traversal without using recursion or a stack,
by temporarily modifying the tree.

For a valid BST:

The inorder traversal MUST be strictly increasing.

Why this is hard?

Because:

You must maintain inorder order.

You have to restore the tree after temporary pointer changes.

You cannot use recursion or extra memory.

Explanation (Step-by-Step)
Goal

Traverse the tree in inorder without recursion/stack:
    If left subtree is null, visit node, and move right.
    Else, find inorder predecessor (rightmost node in left subtree).
    If predecessor’s right is null, make a temporary link to current node and move left.
    If predecessor’s right is current, restore link, visit node, move right.
    Keep track of last visited value.
    If current value ≤ last value → NOT a BST.
 */

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class ValidateBSTMorris {

    public static boolean isValidBST(Node root) {
        Node current = root;
        Integer prev = null; // stores last visited value

        while (current != null) {
            if (current.left == null) {
                // Visit node
                if (prev != null && current.val <= prev) {
                    return false;
                }
                prev = current.val;

                current = current.right;
            } else {
                // Find inorder predecessor
                Node pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                // Make thread
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    // Restore thread
                    pre.right = null;

                    // Visit current
                    if (prev != null && current.val <= prev) {
                        return false;
                    }
                    prev = current.val;

                    current = current.right;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Valid BST Example
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);

        System.out.println("Is Valid BST? " + isValidBST(root));

        // Invalid BST Example
        Node root2 = new Node(5);
        root2.left = new Node(1);
        root2.right = new Node(4);
        root2.right.left = new Node(3); // violates BST rule
        root2.right.right = new Node(6);

        System.out.println("Is Valid BST? " + isValidBST(root2));
    }
}

/*
Is Valid BST? true
Is Valid BST? false




 */