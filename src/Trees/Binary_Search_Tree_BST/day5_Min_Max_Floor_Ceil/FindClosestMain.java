package Trees.Binary_Search_Tree_BST.day5_Min_Max_Floor_Ceil;


class Node4 {
    int data;
    Node4 left, right;

    Node4(int data) {
        this.data = data;
    }
}

class BST4 {
    Node4 insert(Node4 root, int val) {
        if (root == null) return new Node4(val);

        if (val < root.data) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }
}

public class FindClosestMain {

    static int closestValue(Node4 root, int x) {

        int closest = root.data;

        while (root != null) {

            // Update closest if current node is nearer to x
            if (Math.abs(root.data - x) < Math.abs(closest - x)) {
                closest = root.data;
            }

            if (x < root.data) {
                root = root.left;
            }
            else if (x > root.data) {
                root = root.right;
            }
            else {
                return root.data;  // exact match
            }
        }

        return closest;
    }

    public static void main(String[] args) {

        BST4 bst = new BST4();
        Node4 root = null;

        int[] arr = {50, 30, 20, 40, 70, 60, 80};
        for (int x : arr) root = bst.insert(root, x);

        System.out.println("Closest to 67 = " + closestValue(root, 67));
        System.out.println("Closest to 28 = " + closestValue(root, 28));
        System.out.println("Closest to 49 = " + closestValue(root, 49));
    }

}

//Closest to 67 = 70
//Closest to 28 = 30
//Closest to 49 = 50