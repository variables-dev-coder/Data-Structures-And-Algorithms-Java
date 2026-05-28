package dsf_basics_tree_traversals;

class Node4 {

    int data;
    Node4 left, right;

    Node4(int data) {
        this.data = data;
    }
}

public class DFSThinking {

    static void dfs(Node4 root) {

        if (root == null) {
            return;
        }

        System.out.println("Visiting Node: " + root.data);

        dfs(root.left);

        dfs(root.right);

        System.out.println("Backtracking From: " + root.data);
    }

    public static void main(String[] args) {

        Node4 root = new Node4(1);

        root.left = new Node4(2);
        root.right = new Node4(3);

        root.left.left = new Node4(4);
        root.left.right = new Node4(5);

        dfs(root);
    }
}
