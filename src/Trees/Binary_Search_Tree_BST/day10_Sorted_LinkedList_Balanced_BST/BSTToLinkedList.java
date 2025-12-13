package Trees.Binary_Search_Tree_BST.day10_Sorted_LinkedList_Balanced_BST;


class Node2 {
    int val;
    Node2 left, right;
    Node2(int v) {
        val = v;
    }
}

public class BSTToLinkedList {

    static Node2 prev = null;
    static Node2 head = null;

    // Convert BST to Sorted Doubly Linked List
    static void bstToDLL(Node2 root) {
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

    static void printList(Node2 head) {
        Node2 curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Node2 root = new Node2(50);
        root.left = new Node2(30);
        root.right = new Node2(70);
        root.left.left = new Node2(20);
        root.left.right = new Node2(40);
        root.right.left = new Node2(60);
        root.right.right = new Node2(80);

        bstToDLL(root);
        printList(head);
    }

}

// 20 30 40 50 60 70 80