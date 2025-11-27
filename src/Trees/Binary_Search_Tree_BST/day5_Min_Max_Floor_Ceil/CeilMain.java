package Trees.Binary_Search_Tree_BST.day5_Min_Max_Floor_Ceil;


class Node3 {
    int data;
    Node3 left, right;

    Node3(int data) {
        this.data = data;
    }
}

class BST3 {
    Node3 insert(Node3 root, int val) {
        if (root == null) return new Node3(val);

        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }
}


public class CeilMain {

    static Integer ceil(Node3 root, int x) {
        Integer ceilValue = null;

        while (root != null) {

            if (root.data == x)
                return root.data;  // perfect match

            if (x < root.data) {
                ceilValue = root.data;  // store possible ceil
                root = root.left;        // try finding smaller ceil
            } else {
                root = root.right;   // root is small, go right
            }
        }

        return ceilValue;
    }

    public static void main(String[] args) {

        BST3 bst = new BST3();
        Node3 root = null;

        int[] arr = {50, 30, 20, 40, 70, 60, 80};
        for (int x : arr) root = bst.insert(root, x);

        System.out.println("Ceil(25) = " + ceil(root, 25));
        System.out.println("Ceil(65) = " + ceil(root, 65));
        System.out.println("Ceil(20) = " + ceil(root, 20));
    }
}

//Ceil(25) = 30
//Ceil(65) = 70
//Ceil(20) = 20