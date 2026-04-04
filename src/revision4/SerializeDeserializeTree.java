package revision4;

import java.util.*;

public class SerializeDeserializeTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 🔥 Serialize
    public static String serialize(TreeNode root) {

        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("null,");
                continue;
            }

            sb.append(node.val).append(",");

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    // 🔥 Deserialize
    public static TreeNode deserialize(String data) {

        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty()) {

            TreeNode parent = queue.poll();

            // Left child
            if (!values[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.left);
            }
            i++;

            // Right child
            if (!values[i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize
        String data = serialize(root);
        System.out.println("Serialized: " + data);

        // Deserialize
        TreeNode newRoot = deserialize(data);

        System.out.print("Level Order after Deserialize: ");
        printLevelOrder(newRoot);
    }

    // Helper to verify
    public static void printLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) continue;

            System.out.print(node.val + " ");

            q.offer(node.left);
            q.offer(node.right);
        }
    }
}
