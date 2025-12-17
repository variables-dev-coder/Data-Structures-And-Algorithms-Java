package Trees.Binary_Search_Tree_BST.day11_BST_based_Problems;

public class Notes {
    public static void main(String[] args) {

        /*

DSA Day 76 – BST Day 11
-----------------------
BST-Based Applied Problems (Interview Grade)

1. Range Sum in BST
-------------------
Problem
Find the sum of all node values in range [L, R].

Key Insight
BST lets us skip entire subtrees.
    If node.val < L → skip left
    If node.val > R → skip right
    Else → include + explore both sides

Java Code

int rangeSumBST(Node root, int L, int R) {
    if (root == null) return 0;

    if (root.val < L)
        return rangeSumBST(root.right, L, R);

    if (root.val > R)
        return rangeSumBST(root.left, L, R);

    return root.val
            + rangeSumBST(root.left, L, R)
            + rangeSumBST(root.right, L, R);
}

Dry Run

BST inorder: 10 20 30 40 50 60 70
Range [30, 60]
Included → 30 + 40 + 50 + 60 = 180

-------------------------------------------------------------------------------------------------------------


2. Trim BST in Range [L, R]
---------------------------
Problem
Remove nodes outside [L, R], return valid BST.

Key Insight
Use BST pruning:
    If node < L → discard left subtree
    If node > R → discard right subtree

Java Code

Node trimBST(Node root, int L, int R) {
    if (root == null) return null;

    if (root.val < L)
        return trimBST(root.right, L, R);

    if (root.val > R)
        return trimBST(root.left, L, R);

    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L, R);

    return root;
}

Dry Run

Before: 10 20 30 40 50 60 70
Trim [25, 60] → 30 40 50 60


--------------------------------------------------------------------------------------------------------------


3. Convert BST → Greater Sum Tree (GST)
---------------------------------------
Problem
Replace each node with sum of all greater or equal values.

Key Insight
Reverse inorder traversal (Right → Root → Left)

Java Code

int sum = 0;

void bstToGST(Node root) {
    if (root == null) return;

    bstToGST(root.right);

    sum += root.val;
    root.val = sum;

    bstToGST(root.left);
}

Dry Run

BST inorder: 10 20 30 40

Reverse inorder:

40 → sum=40
30 → sum=70
20 → sum=90
10 → sum=100

Result BST: 100 90 70 40


---------------------------------------------------------------------------------------------------------


4. BST Iterator (LeetCode #173)
Problem
Implement iterator returning next smallest element.

Key Insight

Simulate inorder traversal using stack

Code

import java.util.*;

class BSTIterator {
    Stack<Node> stack = new Stack<>();

    BSTIterator(Node root) {
        pushLeft(root);
    }

    void pushLeft(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    int next() {
        Node node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }
}

Dry Run

BST inorder: 10 20 30 40
Iterator output: 10 → 20 → 30 → 40


         */
    }
}
