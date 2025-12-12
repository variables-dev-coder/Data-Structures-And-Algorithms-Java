package Trees.Binary_Search_Tree_BST.day9_Kth_Smallest_Largest;

/*
Recursive inorder (kth smallest) — explanation + runnable code
Idea

Perform inorder recursion and keep a counter. When counter == k return value (use wrapper object / global state).
 */

public class KthSmallestRecursive {

    static class Node {
        int val; Node left, right;
        Node(int v){ val = v; }
    }

    static class Counter {
        int count;
        int value;
        Counter(){ count = 0; value = Integer.MIN_VALUE; }
    }

    // kth smallest recursive
    static void kthSmallestRec(Node root, int k, Counter c) {
        if (root == null) return;
        kthSmallestRec(root.left, k, c);
        if (c.count < k) {
            c.count++;
            if (c.count == k) {
                c.value = root.val;
                return;
            }
        }
        kthSmallestRec(root.right, k, c);
    }

    public static int kthSmallest(Node root, int k) {
        Counter c = new Counter();
        kthSmallestRec(root, k, c);
        return c.value; // caller must ensure k valid
    }

    // build sample tree and test
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.println("Inorder: 20 30 40 50 60 70 80");
        System.out.println("3rd smallest = " + kthSmallest(root, 3)); // 40
        System.out.println("1st smallest = " + kthSmallest(root, 1)); // 20
    }
}

//Inorder: 20 30 40 50 60 70 80
//3rd smallest = 40
//1st smallest = 20

//Dry run (k=3)
//Visit 20 (count=1), 30 (count=2), 40 (count=3) → found 40. Recursion stops unwinding when found.