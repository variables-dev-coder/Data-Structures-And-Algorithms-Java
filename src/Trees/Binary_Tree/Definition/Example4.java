package Trees.Binary_Tree.Definition;

public class Example4 {
    static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(7);

        System.out.println("Is root leaf? " + isLeaf(root));       // false
        System.out.println("Is left child leaf? " + isLeaf(root.left)); // true
    }
}

