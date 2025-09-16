package Trees.Binary_Tree.Definition;

public class Example2 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        System.out.println("Root: " + root.val);  // 1
        System.out.println("Left Child: " + root.left.val);  // 2
        System.out.println("Right Child: " + root.right.val);   // 3
    }
}
