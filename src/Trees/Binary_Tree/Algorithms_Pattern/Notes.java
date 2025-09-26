package Trees.Binary_Tree.Algorithms_Pattern;

public class Notes {
    public static void main(String[] args) {

        /*

Binary Tree Algorithms & Patterns (Mastery)
===========================================

1. Recursive Implementations (DFS Style)
----------------------------------------
    Idea: Use recursion to go down the tree until null (base case), then process on the way back up.
    When to use: Tree problems that naturally fit recursion (height, sum, traversals).

Template:

int solve(TreeNode root) {
    if (root == null) return base;   // base condition
    // recursive calls
    int left = solve(root.left);
    int right = solve(root.right);
    // combine results
    return process(root, left, right);
}


Example: Height of Binary Tree

int height(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(height(root.left), height(root.right));
}



========================================================================================================



2. Iterative Implementations (Using Stack/Queue)
------------------------------------------------
    Idea: Replace recursion with explicit stack (DFS) or queue (BFS).
    Why: Avoid recursion depth issues, iterative BFS/DFS often required in interviews.

DFS Iterative (using Stack):

void preorder(TreeNode root) {
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        System.out.print(node.val + " ");
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
}

BFS Iterative (using Queue):

void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        TreeNode node = q.poll();
        System.out.print(node.val + " ");
        if (node.left != null) q.add(node.left);
        if (node.right != null) q.add(node.right);
    }
}



=============================================================================================================



3. Divide & Conquer (Return Subtree Results)
--------------------------------------------
    Idea: Solve problem by breaking tree into subproblems → compute left, right subtree → merge.
    Pattern:
        Get result from left subtree
        Get result from right subtree
        Combine with root

Example: Check if Tree is Balanced

int checkBalance(TreeNode root) {
    if (root == null) return 0;

    int left = checkBalance(root.left);
    if (left == -1) return -1;

    int right = checkBalance(root.right);
    if (right == -1) return -1;

    if (Math.abs(left - right) > 1) return -1;

    return 1 + Math.max(left, right);
}

boolean isBalanced(TreeNode root) {
    return checkBalance(root) != -1;
}

Divide & Conquer ensures O(N) instead of recomputing heights.



===============================================================================================================




4. BFS Level-wise Processing (Level-order with Queue)
-----------------------------------------------------

    Idea: Use queue to process nodes level by level → important for problems like “Level sum”,
    “Max width”, “Zig-zag traversal”.

Template:

void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        int size = q.size();  // nodes in this level
        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        System.out.println(); // next line for new level
    }
}


Key Takeaways
-------------
    1.Recursive DFS – clean, simple, but can cause stack overflow.
    2.Iterative DFS (stack) – manual recursion control.
    3.Divide & Conquer – efficient, avoid recomputation.
    4.BFS Level-order – best for level-based problems.

    Mastering these 4 patterns makes 90% of binary tree problems solvable.




=========================================================================================================




Binary Tree Algorithms & Patterns – Interview Q&A
==================================================
Recursive (DFS)
---------------

1.Q: How do you calculate the height of a binary tree using recursion?
  A: Use DFS, base case null → 0, return 1 + max(leftHeight, rightHeight).

2.Q: Why is recursion a natural fit for tree problems?
  A: Trees are recursive structures (node → left subtree, right subtree).
     Each subtree is itself a smaller tree, so recursion models it perfectly.

Iterative (Stack/Queue)
-----------------------

3.Q: Implement iterative preorder traversal of a binary tree.
  A: Use a stack. Push root, pop, print, then push right then left (so left is processed first).

4.Q: What’s the difference between stack-based DFS and queue-based BFS in trees?
  A:
    Stack (DFS): Goes deep before exploring siblings.
    Queue (BFS): Processes level by level, breadth-first.

Divide & Conquer
----------------

5.Q: How do you check if a binary tree is height-balanced?
  A: Use divide & conquer: get height of left & right → if abs diff > 1 return false.
     Optimize by returning -1 early if imbalance found.

6.Q: Why is divide & conquer better than naive recursive solutions in trees?
  A: It avoids repeated calculations. Example: balanced tree check in O(N) instead of O(N²).

BFS Level-wise
---------------

7.Q: How do you find the maximum width of a binary tree?
  A: Use BFS with queue, process level by level, track size of each level, return max.

8.Q: How can you print a binary tree level by level (like rows)?
  A: Use BFS, for each level get queue size, process that many nodes, then print newline.

Mixed / Advanced
----------------

9.Q: When would you prefer iterative solutions over recursive in binary trees?
  A:
    Very deep trees (to avoid stack overflow).
    Interview scenarios where interviewer wants explicit stack/queue handling.

10.Q: Explain Morris traversal. Why is it special?
   A: Morris traversal is an inorder traversal using O(1) space. It modifies tree links
   temporarily (using threaded connections), unlike recursion/stack that require O(H) memory.


   
         */
    }
}
