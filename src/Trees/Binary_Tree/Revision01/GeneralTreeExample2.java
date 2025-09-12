package Trees.Binary_Tree.Revision01;


import java.util.ArrayList;
import java.util.List;

class Node {
    String data;
    List<Node> children;

    Node(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    void addChild(Node child) {
        children.add(child);
    }
}

public class GeneralTreeExample2 {
    // Preorder Traversal
    static void preorder(Node root) {
        if (root == null) return;

        System.out.println(root.data + " "); // Visit root

        for (Node child : root.children) {
            preorder(child);   // Recursively visit children
        }
    }

    public static void main(String[] args) {
        // Build Tree

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        A.addChild(B);
        A.addChild(C);
        A.addChild(D);
        C.addChild(E);
        C.addChild(F);


        // Traversal
        System.out.println("Preorder Traversal of General Tree:");
        preorder(A);
    }
}
