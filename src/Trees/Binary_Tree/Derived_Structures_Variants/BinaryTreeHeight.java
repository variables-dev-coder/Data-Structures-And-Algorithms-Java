package Trees.Binary_Tree.Derived_Structures_Variants;

/*
Calculate Height (Depth) of a Binary Tree
Concept Recap
    The height of a tree = number of edges in the longest path from root to leaf.
    If the tree is empty → height = 0
    Formula (recursive):

height(root) = 1 + max(height(root.left), height(root.right))


We’ll see both:
    Recursive approach (DFS)
    Iterative approach (BFS using Queue)
 */

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class BinaryTreeHeight {

    //  Recursive Height
    static int heightRecursive(Node root) {
        if (root == null)
            return 0;
        int leftHeight = heightRecursive(root.left);
        int rightHeight = heightRecursive(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //  Iterative Height (Level Order using Queue)
    static int heightIterative(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            height++; // new level
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \
            4   5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Recursive Height: " + heightRecursive(root)); // expected 3
        System.out.println("Iterative Height: " + heightIterative(root)); // expected 3
    }
}


//Recursive Height: 3
//Iterative Height: 3

/*
Dry Run
Tree:
        1
       / \
      2   3
     / \
    4   5

Recursive calls
    height(4) → 1
    height(5) → 1
    height(2) → 1 + max(1,1) = 2
    height(3) → 1
    height(1) → 1 + max(2,1) = 3
        Final Height = 3

Iterative BFS
    Level 1: [1] → height = 1
    Level 2: [2,3] → height = 2
    Level 3: [4,5] → height = 3
        Final Height = 3

Complexity
Time: O(n)
Space: O(h) (recursive stack) or O(n) (queue for BFS)

 */