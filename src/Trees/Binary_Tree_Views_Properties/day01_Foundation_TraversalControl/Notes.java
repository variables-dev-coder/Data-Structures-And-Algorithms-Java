package Trees.Binary_Tree_Views_Properties.day01_Foundation_TraversalControl;

public class Notes {
    public static void main(String[] args) {


        /*

Day 1 – Foundation (Traversal Control)
=======================================
🎯 Goal: Control tree levels confidently

🧠 Core Idea of Day 1
---------------------
Day 1 is about thinking level-by-level, not node-by-node.
    DFS = depth first (recursion, stack)
    BFS = level first (queue)

From today, Queue becomes your main weapon.


1️⃣ Level Order Traversal (BFS)
------------------------------
🔹 Concept
    Visit nodes level by level
    Use Queue
    Root → Left → Right

🔹 Algorithm (Think First, Code Later)
--------------------------------------
1. Create a queue
2. Add root
3. While queue not empty:
    - Remove front node
    - Process it
    - Add left child
    - Add right child

🔹 Java Code (Clean & Interview-Ready)
--------------------------------------

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size(); // nodes in current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}

🧠 Why size is important?
👉 It locks one level
👉 Without it, you lose level boundaries


2️⃣ Level Order By Line (Each Level Separate)
--------------------------------------------
🔹 Output Example
-----------------
1
2 3
4 5 6

🔹 Logic
--------
Same BFS
Print after processing size nodes

🔹 Java Code
------------

public void levelOrderByLine(TreeNode root) {
    if (root == null) return;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        int size = q.size();

        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        System.out.println();
    }
}

🎯 Interview Tip:
If interviewer asks “print level by level” → this is the answer.


3️⃣ Reverse Level Order Traversal
---------------------------------
🔹 Concept
-----------
Normal BFS → Bottom to Top

🔹 Trick
---------
Use Stack OR add levels at front

🔹 Java Code (Best Approach)
----------------------------

public List<List<Integer>> reverseLevelOrder(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    if (root == null) return result;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        int size = q.size();
        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            TreeNode node = q.poll();
            level.add(node.val);

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        result.addFirst(level); // 🔥 key line
    }
    return result;
}

🔁 Recursive vs Iterative Thinking (VERY IMPORTANT)
---------------------------------------------------
❌ Recursive DFS
Good for depth problems
Bad for level control

✅ Iterative BFS
Natural for:
    Views
    Zigzag
    Vertical order
    Distance problems

📌 Rule to remember
    If problem says level / view / order → think Queue

🧠 Common Interview Traps (Day 1)
---------------------------------
Forgetting size → wrong levels
Mixing DFS logic in BFS problems
Using recursion for level problems (inefficient)


         */
    }
}
