package Trees.Binary_Search_Tree_BST.day9_Kth_Smallest_Largest;

/*
Kth Largest (reverse inorder) — runnable code

Mirror the iterative logic but traverse right first.
 */


import java.util.ArrayDeque;
import java.util.Deque;

public class KthLargestIterative {

    static class Node {
        int val; Node left, right;
        Node(int v){ val = v; }
    }

    public static int kthLargest(Node root, int k) {
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right; // go right first
            }
            curr = stack.pop();
            count++;
            if (count == k) return curr.val;
            curr = curr.left;
        }
        throw new IllegalArgumentException("k is larger than number of nodes");
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("2nd largest = " + kthLargest(root, 2)); // 70
        System.out.println("1st largest = " + kthLargest(root, 1)); // 80
    }
}

//2nd largest = 70
//1st largest = 80

//Dry run (k=2): traverse 50→right 70→right 80 pop (count1), pop 70 (count2) → return 70.