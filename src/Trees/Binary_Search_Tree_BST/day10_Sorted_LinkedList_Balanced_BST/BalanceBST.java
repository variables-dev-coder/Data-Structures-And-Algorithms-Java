package Trees.Binary_Search_Tree_BST.day10_Sorted_LinkedList_Balanced_BST;


import java.util.ArrayList;
import java.util.List;

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

    static <List> Node balanceBST(Node root) {
        java.util.List<Integer> list = new ArrayList<>();
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

// 10 20 30 40