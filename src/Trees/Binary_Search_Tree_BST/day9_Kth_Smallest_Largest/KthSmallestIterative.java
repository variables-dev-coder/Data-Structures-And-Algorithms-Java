package Trees.Binary_Search_Tree_BST.day9_Kth_Smallest_Largest;

/*
Iterative using stack (kth smallest) — runnable code (preferred)
Idea

Simulate recursion with stack: push left nodes down, pop one by one, increment count; after popping, go right.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestIterative {
    static class Node {
        int val; Node left, right;
        Node(int v){ val = v; }
    }

    // kth smallest iterative
    public static int kthSmallest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            count++;
            if (count == k) return curr.val;
            curr = curr.right;
        }
        throw new IllegalArgumentException("k is larger than number of nodes");
    }

    // test
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("3rd smallest = " + kthSmallest(root, 3)); // 40
        System.out.println("5th smallest = " + kthSmallest(root, 5)); // 60
    }
}

//3rd smallest = 40
//5th smallest = 60

//Dry run (stack)
//Push 50 → 30 → 20 (leftmost). Pop 20 (count=1). Pop 30 (count=2).
// Pop 40? actually after popping 30, go right to 40 push->pop count=3 -> return 40.