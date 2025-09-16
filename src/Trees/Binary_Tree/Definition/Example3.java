package Trees.Binary_Tree.Definition;

public class Example3 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Tree built with root = " + root.val); // Tree built with root = 1
    }
}
