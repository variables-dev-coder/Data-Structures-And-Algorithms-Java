package Trees.General_Trees;


import java.util.*;

class Node {
    int data;
    List<Node> children = new ArrayList<>();

    Node(int data) {
        this.data = data;
    }
}

public class GeneralTreeExample1 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        child1.children.add(new Node(5));
        child1.children.add(new Node(6));

        printTree(root, 0);
    }

    static void printTree(Node node, int level) {
        System.out.println(" ".repeat(level) + node.data);
        for (Node child : node.children) {
            printTree(child, level + 2);
        }
    }
}

/*
1
  2
    5
    6
  3
  4

 */