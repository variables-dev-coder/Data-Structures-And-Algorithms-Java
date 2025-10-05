package Trees.Binary_Tree.Derived_Structures_Variants;

/*
Count Nodes and Leaf Nodes in a Binary Tree
Concept Recap
    Total Nodes: every node contributes 1 + left_count + right_count
    Leaf Nodes: nodes with no children (left == null && right == null)

We’ll see:
    Count total nodes
    Count leaf nodes
    (Bonus) Count internal nodes = total - leaf nodes
 */

class Node2 {
    int val;
    Node2 left, right;

    Node2(int val) {
        this.val = val;
    }
}

public class CountNodesExample {

    //  Count total nodes
    static int countNodes(Node2 root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //  Count leaf nodes
    static int countLeafNodes(Node2 root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    //  Count internal nodes
    static int countInternalNodes(Node2 root) {
        int total = countNodes(root);
        int leaves = countLeafNodes(root);
        return total - leaves;
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \
             4   5
        */
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);

        System.out.println("Total Nodes: " + countNodes(root));       // 5
        System.out.println("Leaf Nodes: " + countLeafNodes(root));    // 3 (4,5,3)
        System.out.println("Internal Nodes: " + countInternalNodes(root)); // 2 (1,2)
    }
}

//Total Nodes: 5
//Leaf Nodes: 3
//Internal Nodes: 2

/*
Dry Run
Tree:
        1
       / \
      2   3
     / \
    4   5
Step 1 – Total Nodes

countNodes(1)
= 1 + countNodes(2) + countNodes(3)
= 1 + (1 + countNodes(4) + countNodes(5)) + 1
= 1 + (1 + 1 + 1) + 1 = 5

Total Nodes = 5

Step 2 – Leaf Nodes
Node 4 → leaf
Node 5 → leaf
Node 3 → leaf
    → Total Leaf Nodes = 3

Step 3 – Internal Nodes = 5 - 3 = 2
(Internal nodes: 1 and 2)

Complexity
    Time: O(n) (visits every node once)
    Space: O(h) (recursive stack height)


 */
