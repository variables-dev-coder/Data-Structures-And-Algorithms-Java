package Trees.treeRevision;

import java.util.*;

public class BurnTree {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    public static int burnTree(Node root, int target) {

        Map<Node, Node> parentMap = new HashMap<>();
        Node targetNode = buildParent(root, parentMap, target);

        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                    burned = true;
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                    burned = true;
                }

                // parent
                if (parentMap.get(curr) != null && !visited.contains(parentMap.get(curr))) {
                    q.add(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                    burned = true;
                }
            }

            if (burned) time++;
        }

        return time;
    }

    // Build parent map + find target node
    static Node buildParent(Node root, Map<Node, Node> map, int target) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node targetNode = null;

        while (!q.isEmpty()) {

            Node curr = q.poll();

            if (curr.val == target) {
                targetNode = curr;
            }

            if (curr.left != null) {
                map.put(curr.left, curr);
                q.add(curr.left);
            }

            if (curr.right != null) {
                map.put(curr.right, curr);
                q.add(curr.right);
            }
        }

        return targetNode;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int target = 5;

        System.out.println("Time to burn tree: " + burnTree(root, target)); // 3
    }
}
