package Trees.Binary_Search_Tree_BST.day9_Kth_Smallest_Largest;

public class Notes {
    public static void main(String[] args) {


        /*

1 - Intuition (why BST helps)
-----------------------------
A BST’s inorder traversal visits nodes in sorted (ascending) order.
So:
    kth smallest = kth element in inorder.
    kth largest = kth element in reverse inorder (right → root → left) or (n-k+1)th in inorder.

This gives simple solutions that are efficient (O(h + k) time) and use O(h)
space for recursion/stack, where h = tree height.


2 - Approaches overview
-----------------------
    1.Recursive inorder counting (easy, clear)
    2.Iterative using explicit stack (preferred in interviews)
    3.Reverse inorder for kth largest (mirror of above)
    4.Morris traversal (O(1) extra space) — advanced
    5.Augmented BST (store subtree sizes) — best for repeated queries (O(h) per query)

Example

         50
       /    \
     30      70
    /  \    /  \
   20  40  60  80

Inorder: 20,30,40,50,60,70,80
So:
    3rd smallest = 40
    2nd largest = 70


         */
    }
}
