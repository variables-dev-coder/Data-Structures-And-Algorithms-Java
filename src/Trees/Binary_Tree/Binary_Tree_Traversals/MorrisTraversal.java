package Trees.Binary_Tree.Binary_Tree_Traversals;

// Morris Inorder Traversal – O(1) Space

class Node5 {
    int val;
    Node5 left, right;

    Node5(int v) {
        val = v; left = right = null;
    }
}

public class MorrisTraversal {
    static void morrisInorder(Node5 root) {
        Node5 curr = root;
        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                Node5 pred = curr.left;
                while (pred.right != null && pred.right != curr)
                    pred = pred.right;

                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node5 root = new Node5(1);
        root.left = new Node5(2);
        root.right = new Node5(3);
        root.left.left = new Node5(4);
        root.left.right = new Node5(5);

        System.out.print("Morris Inorder: ");
        morrisInorder(root); // Output: 4 2 5 1 3
    }
}

// Morris Inorder: 4 2 5 1 3
// Inorder traversal without recursion or stack, O(1) space.