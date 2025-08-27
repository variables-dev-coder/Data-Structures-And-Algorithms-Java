package Trees.General_Trees;

public class GeneralTreeExample3 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        root.children.add(n2);
        root.children.add(n3);
        n2.children.add(n4);
        n4.children.add(n5);

        System.out.println("Height of Tree: " + height(root));
    }

    static int height(Node node) {
        if (node == null) return 0;
        int maxChildHeight = 0;
        for (Node child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }
        return 1 + maxChildHeight;
    }
}

//Height of Tree: 4