package Trees.Binary_Tree.Types;

//Check if a Binary Tree is Complete
//Condition:
//All levels are completely filled except possibly the last.
//The last level is filled from left to right.
//Used in Heap implementation.

class Node4 {
    int val;
    Node4 left, right;
    Node4(int v) {
        val = v;
        left = right = null;
    }
}

public class CompleteBinaryTreeCheck {
    // Count total nodes in the tree
    static int countNodes(Node4 root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Utility function to check completeness
    static boolean isComplete(Node4 root, int index, int totalNodes) {
        if (root == null) return true;

        // If index assigned to current node is >= total nodes → not complete
        if (index >= totalNodes) return false;

        // Check left and right subtrees
        return isComplete(root.left, 2 * index + 1, totalNodes) &&
                isComplete(root.right, 2 * index + 2, totalNodes);
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \  /
          4  5 6
        */
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(3);
        root.left.left = new Node4(4);
        root.left.right = new Node4(5);
        root.right.left = new Node4(6);

        int totalNodes = countNodes(root);
        System.out.println("Is Complete Binary Tree? " +
                isComplete(root, 0, totalNodes)); // true
    }

}

//Is Complete Binary Tree? true