package Trees.Binary_Search_Tree_BST.day5_Min_Max_Floor_Ceil;


class Node5 {
    int data;
    Node5 left, right;

    Node5(int data) {
        this.data = data;
    }
}

class BST5 {
    Node5 insert(Node5 root, int val) {
        if (root == null) return new Node5(val);
        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
}

public class Kth_Smallest_Element {

    static int count = 0;

    static Integer kthSmallest(Node5 root, int k) {
        count = 0;
        return inorder(root, k);
    }

    static Integer inorder(Node5 root, int k) {
        if (root == null) return null;

        // Left
        Integer left = inorder(root.left, k);
        if (left != null) return left;

        // Visit current
        count++;
        if (count == k) return root.data;

        // Right
        return inorder(root.right, k);
    }

    public static void main(String[] args) {

        BST5 bst = new BST5();
        Node5 root = null;

        int[] arr = {50, 30, 20, 40, 70, 60, 80};
        for (int x : arr) root = bst.insert(root, x);

        System.out.println("3rd Smallest = " + kthSmallest(root, 3));
        System.out.println("5th Smallest = " + kthSmallest(root, 5));
    }

}

//3rd Smallest = 40
//5th Smallest = 60