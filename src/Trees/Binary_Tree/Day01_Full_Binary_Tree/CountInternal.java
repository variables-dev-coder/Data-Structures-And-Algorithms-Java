package Trees.Binary_Tree.Day01_Full_Binary_Tree;


//Count Internal Nodes in a Full Binary Tree
//Formula: Internal Nodes = (n - 1) / 2, where n is total nodes.


public class CountInternal {
    static int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static int countInternalNodes(Node root) {
        int n = countNodes(root);
        return (n - 1) / 2;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Internal Nodes = " + countInternalNodes(root));
    }
}

//Internal Nodes = 3

/*
Dry Run:
Total nodes = 7
Internal nodes = (7 - 1)/2 = 3
 */

