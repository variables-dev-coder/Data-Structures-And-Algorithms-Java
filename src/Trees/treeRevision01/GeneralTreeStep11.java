package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep11 {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // 🔹 Serialize
    public static void serialize(Node root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        list.add(root.children.size());

        for (Node child : root.children) {
            serialize(child, list);
        }
    }

    // 🔹 Deserialize
    static int index = 0;

    public static Node deserialize(List<Integer> list) {
        if (index >= list.size()) return null;

        int val = list.get(index++);
        int size = list.get(index++);

        Node root = new Node(val);

        for (int i = 0; i < size; i++) {
            root.children.add(deserialize(list));
        }

        return root;
    }

    // Print tree
    public static void print(Node root) {
        if (root == null) return;

        System.out.print(root.val + " -> ");
        for (Node child : root.children) {
            System.out.print(child.val + " ");
        }
        System.out.println();

        for (Node child : root.children) {
            print(child);
        }
    }

    public static void main(String[] args) {

        /*
            Tree:
                    1
                  / | \
                 2  3  4
                / \
               5   6
        */

        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        n2.children.add(new Node(5));
        n2.children.add(new Node(6));

        // Serialize
        List<Integer> data = new ArrayList<>();
        serialize(root, data);

        System.out.println("Serialized: " + data);

        // Deserialize
        index = 0;
        Node newRoot = deserialize(data);

        System.out.println("Deserialized Tree:");
        print(newRoot);
    }
}
