package Trees.Binary_Search_Tree_BST.day5_Min_Max_Floor_Ceil;


class Node {
    int data;
    Node left, right;

    Node (int data) {
        this.data = data;
    }
}

class BST {

    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }
}


public class MinMax {
    static int findMin(Node root) {
        if (root == null) throw new RuntimeException("Empty Tree");

        while (root.left != null)
            root = root.left;

        return root.data;
    }

    static int findMax(Node root) {
        if (root == null) throw new RuntimeException("Empty Tree");

        while (root.right != null)
            root = root.right;

        return root.data;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        Node root = null;

        int[] arr = {50, 30, 20, 40, 70, 60, 80};

        for (int x : arr) root = bst.insert(root, x);

        System.out.println("Min Value : " + findMin(root));
        System.out.println("Max Value : " + findMax(root));
    }

}

//Min Value : 20
//Max Value : 80