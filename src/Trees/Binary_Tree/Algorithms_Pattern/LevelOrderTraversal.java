package Trees.Binary_Tree.Algorithms_Pattern;

// BFS Level-Order Traversal

import java.util.LinkedList;
import java.util.Queue;

class Node4 {
    int val;
    Node4 left, right;

    Node4(int v) {
        val = v;
        left = right = null;
    }
}

public class LevelOrderTraversal {

    static void levelOrder(Node4 root) {
        if (root == null) return;

        Queue<Node4> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // nodes in this level

            for (int i = 0; i < levelSize; i++) {
                Node4 curr = queue.poll();
                System.out.print(curr.val + " ");

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            System.out.println(); // new line after each level
        }
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(3);
        root.left.left = new Node4(4);
        root.left.right = new Node4(5);

        System.out.println("Level-order traversal:");
        levelOrder(root);
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


Start: Queue = [1]
→ Pop 1 → print 1
→ Push 2, 3
Output:

1


Queue = [2,3]
→ Pop 2 → print 2, push 4,5
→ Pop 3 → print 3
Output:

1
2 3


Queue = [4,5]
→ Pop 4 → print 4
→ Pop 5 → print 5
Output:

1
2 3
4 5


Queue empty → traversal done.

Output
Level-order traversal:
1
2 3
4 5

 */