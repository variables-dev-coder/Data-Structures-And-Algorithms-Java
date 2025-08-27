package Trees.General_Trees;

public class GeneralTreeExample2 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.get(0).children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));

        System.out.println("Total Nodes: " + countNodes(root));
    }

    static int countNodes(Node node) {
        int count = 1;
        for (Node child : node.children) {
            count += countNodes(child);
        }
        return count;
    }
}

//Total Nodes: 5