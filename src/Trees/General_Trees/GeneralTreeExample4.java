package Trees.General_Trees;

public class GeneralTreeExample4 {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        root.children.add(n2);
        root.children.add(n3);
        n2.children.add(n4);

        System.out.println("Is 4 present? " + search(root, 4));
        System.out.println("Is 10 present? " + search(root, 10));
    }

    static boolean search(Node node, int key) {
        if (node.data == key) return true;
        for (Node child : node.children) {
            if (search(child, key)) return true;
        }
        return false;
    }
}

//Is 4 present? true
//Is 10 present? false