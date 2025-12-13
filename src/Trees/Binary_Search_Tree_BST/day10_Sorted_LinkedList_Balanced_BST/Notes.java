package Trees.Binary_Search_Tree_BST.day10_Sorted_LinkedList_Balanced_BST;

public class Notes {
    public static void main(String[] args) {

        /*

DSA Learning Day 75
===================
BST → Sorted Linked List → Balanced BST (with AVL intuition)
PART 1: BST → Sorted Linked List
Core Idea
Inorder traversal of BST = sorted order
So if we:
    Traverse BST inorder
    Connect nodes as a Linked List
We get a sorted Linked List



Two Variants Interviewers Ask
    1.Using extra space (Array / List) – easy
    2.In-place conversion (no extra space) – advanced


BST → Sorted Doubly Linked List (In-place)
Logic
    Use inorder traversal
    Keep track of:
        prev → previous visited node
        head → head of linked list

Code (Runnable Java)


class Node {
    int val;
    Node left, right;
    Node(int v) { val = v; }
}

public class BSTToLinkedList {

    static Node prev = null;
    static Node head = null;

    // Convert BST to Sorted Doubly Linked List
    static void bstToDLL(Node root) {
        if (root == null) return;

        bstToDLL(root.left);

        if (prev == null) {
            head = root; // first node
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        bstToDLL(root.right);
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        bstToDLL(root);
        printList(head);
    }
}

🧪 Dry Run

BST inorder → 20 30 40 50 60 70 80
Linked List becomes:
20 ⇄ 30 ⇄ 40 ⇄ 50 ⇄ 60 ⇄ 70 ⇄ 80

Sorted
In-place
O(n) time, O(h) stack

PART 2: Unbalanced BST → Balanced BST
Why This Matters
    Unbalanced BST = O(n) search (bad)
    Balanced BST = O(log n) search (good)

TreeMap, TreeSet internally do this using Red-Black Tree


Strategy (Classic Interview Pattern)
Step 1: BST → Sorted Array (Inorder)
Step 2: Sorted Array → Balanced BST (mid element root)

Code (Runnable Java)


import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int v) { val = v; }
}

public class BalanceBST {

    static void inorder(Node root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    static Node buildBalanced(List<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));

        root.left = buildBalanced(list, start, mid - 1);
        root.right = buildBalanced(list, mid + 1, end);

        return root;
    }

    static Node balanceBST(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return buildBalanced(list, 0, list.size() - 1);
    }

    static void inorderPrint(Node root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.right = new Node(20);
        root.right.right = new Node(30);
        root.right.right.right = new Node(40);

        root = balanceBST(root);
        inorderPrint(root);
    }
}

🧪 Dry Run

Unbalanced:
10 → 20 → 30 → 40
Inorder → [10, 20, 30, 40]

Balanced BST:

      20
     /  \
   10   30
          \
           40


Height reduced
Faster search



PART 3: Rotations (AVL Intro)
Why Rotations?

When BST becomes unbalanced, we rotate nodes to fix height.

Basic Rotations (Conceptual)
Right Rotation (LL Case)

    30              20
   /               /  \
  20      →       10   30
 /
10

Left Rotation (RR Case)

10                20
  \              /  \
   20    →      10   30
     \
      30


AVL uses:
LL
RR
LR
RL

You don’t need full AVL now, but this intuition is GOLD in interviews.


Final Mastery Checklist

Convert BST → Sorted Linked List
In-place logic using inorder
Convert Unbalanced BST → Balanced BST
Understand why balance matters
Strong AVL rotation intuition
Ready for structure transformation questions


         */
    }
}
