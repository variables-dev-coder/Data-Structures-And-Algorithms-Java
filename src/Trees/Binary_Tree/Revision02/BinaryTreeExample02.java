package Trees.Binary_Tree.Revision02;


class Node02 {
    int data;
    Node02 left, right;

    Node02 (int data) {
        this.data = data;
        left = right = null;
    }
}


public class BinaryTreeExample02 {
    Node02 root;

    public static void main(String[] args) {
        BinaryTreeExample02 tree = new BinaryTreeExample02();
        tree.root = new Node02(1);
        tree.root.left = new Node02(2);
        tree.root.right = new Node02(3);
        tree.root.left.left = new Node02(4);
        tree.root.left.right = new Node02(5);


        System.out.println("Binary Tree Created Successfully");
    }
}
