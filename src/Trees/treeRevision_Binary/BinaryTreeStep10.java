package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeStep10 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // 🔹 Serialize (BFS)
    public static String serialize(Node root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr == null) {
                sb.append("null,");
                continue;
            }

            sb.append(curr.val).append(",");
            queue.add(curr.left);
            queue.add(curr.right);
        }

        return sb.toString();
    }

    // 🔹 Deserialize
    public static Node deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] arr = data.split(",");
        Node root = new Node(Integer.parseInt(arr[0]));

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // left child
            if (!arr[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(arr[i]));
                queue.add(curr.left);
            }
            i++;

            // right child
            if (!arr[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(arr[i]));
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Print level order (to verify)
    public static void print(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(curr.val + " ");
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
                 / \
                4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);
        root.right.right = new Node(5);

        // Serialize
        String data = serialize(root);
        System.out.println("Serialized: " + data);

        // Deserialize
        Node newRoot = deserialize(data);

        System.out.print("Deserialized Tree: ");
        print(newRoot);
    }
}
