package Trees.Binary_Tree.Algorithms_Pattern;

// Height of a Binary Tree (Recursive)

class Node1 {
    int val;
    Node1 left, right;

    Node1(int v) {
        val = v;
        left = right = null;
    }
}

public class HeightRecursive {
    // Function to calculate height using recursion
    static int height(Node1 root) {
        if (root == null) return 0; // base case

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */

        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);

        System.out.println("Height of tree: " + height(root)); // Expected 3
    }

}

/*
Dry Run

Tree:

        1
       / \
      2   3
     / \
    4   5

1. Start at root 1.
→ Call height(1)
→ Needs height(2) and height(3).

2. For height(2)
→ Needs height(4) and height(5).
height(4) → left & right are null → return 0 → height = 1.
height(5) → same → return 1.
→ So height(2) = 1 + max(1,1) = 2.


3.For height(3)
→ left & right null → return 1.

Output
Height of tree: 3

 */