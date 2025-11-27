package Trees.Binary_Search_Tree_BST.day5_Min_Max_Floor_Ceil;


class Node2 {
    int data;
    Node2 left, right;

    Node2(int data) {
        this.data = data;
    }
}

class BST2 {
    Node2 insert(Node2 root, int val) {
        if (root == null) return new Node2(val);

        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }
}

public class FloorMain {

    static Integer floor(Node2 root, int x) {
        Integer floorValue = null;

        while (root != null) {

            if (root.data == x)
                return root.data;  // exact match → direct floor

            if (x < root.data) {
                root = root.left;  // go left (looking for smaller values)
            } else {
                floorValue = root.data;  // store possible floor
                root = root.right;       // try to find closer value
            }
        }

        return floorValue;  // may return null if no floor exists
    }

    public static void main(String[] args) {

        BST2 bst = new BST2();
        Node2 root = null;

        int[] arr = {50, 30, 20, 40, 70, 60, 80};
        for (int x : arr) root = bst.insert(root, x);

        System.out.println("Floor(65) = " + floor(root, 65));
        System.out.println("Floor(25) = " + floor(root, 25));
        System.out.println("Floor(75) = " + floor(root, 75));
    }

}

//Floor(65) = 60
//Floor(25) = 20
//Floor(75) = 70