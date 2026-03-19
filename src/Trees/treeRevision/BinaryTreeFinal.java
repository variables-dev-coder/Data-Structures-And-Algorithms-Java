package Trees.treeRevision;

import java.util.*;

class BinaryTreeFinal {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Build Tree
    static Node buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            Node curr = q.poll();

            if (arr[i] != null) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Serialize
    static String serialize(Node root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr == null) {
                sb.append("null ");
                continue;
            }

            sb.append(curr.data + " ");
            q.add(curr.left);
            q.add(curr.right);
        }

        return sb.toString();
    }

    // Deserialize
    static Node deserialize(String data) {

        if (data.isEmpty()) return null;

        String[] values = data.split(" ");

        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < values.length) {

            Node curr = q.poll();

            if (!values[i].equals("null")) {
                curr.left = new Node(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")) {
                curr.right = new Node(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Vertical Order
    static void verticalOrder(Node root) {

        class Pair {
            Node node;
            int hd;

            Pair(Node n, int h) {
                node = n;
                hd = h;
            }
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            map.putIfAbsent(curr.hd, new ArrayList<>());
            map.get(curr.hd).add(curr.node.data);

            if (curr.node.left != null)
                q.add(new Pair(curr.node.left, curr.hd - 1));

            if (curr.node.right != null)
                q.add(new Pair(curr.node.right, curr.hd + 1));
        }

        for (List<Integer> list : map.values()) {
            for (int val : list) {
                System.out.print(val + " ");
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, null, null};

        Node root = buildTree(arr);

        String data = serialize(root);
        System.out.println("Serialized: " + data);

        Node newRoot = deserialize(data);

        System.out.print("Vertical Order: ");
        verticalOrder(newRoot);
    }
}
