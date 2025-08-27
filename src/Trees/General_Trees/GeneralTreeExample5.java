package Trees.General_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class GeneralTreeExample5 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        root.children.add(n2);
        root.children.add(n3);
        n2.children.add(n4);
        n3.children.add(n5);

        levelOrder(root);
    }

    static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            queue.addAll(current.children);
        }
    }
}

//1 2 3 4 5