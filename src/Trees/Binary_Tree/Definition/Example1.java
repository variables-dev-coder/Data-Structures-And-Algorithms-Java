package Trees.Binary_Tree.Definition;



class Node1 {
    int val;
    Node left, right;

    Node1 (int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Example1 {
    public static void main(String[] args) {
        Node1 root = new Node1(10);
        System.out.println("Root value: " + root.val);   // root value: 10
    }
}
