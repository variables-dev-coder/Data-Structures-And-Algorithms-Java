package Trees.Binary_Tree.Core_Operations;


/*
Serialize & Deserialize Binary Tree
Definition:
Serialize: Convert tree → string/array (so it can be stored/transmitted).
Deserialize: Convert string/array → back to tree.
We’ll use Level-Order with null markers.

 */

import java.util.*;

public class BinaryTreeSerialize {
    static class Node7 {
        int data;
        Node7 left, right;

        Node7(int data) {
            this.data = data;
        }
    }

    Node7 root;

    // Serialize: Level-order traversal with "null"
    public String serialize(Node7 root) {
        if (root == null) return "";

        Queue<Node7> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Node7 temp = q.poll();
            if (temp == null) {
                sb.append("null,");
                continue;
            }
            sb.append(temp.data).append(",");
            q.add(temp.left);
            q.add(temp.right);
        }
        return sb.toString();
    }

    // Deserialize: build tree back from string
    public Node7 deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        Node7 root = new Node7(Integer.parseInt(values[0]));

        Queue<Node7> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < values.length) {
            Node7 parent = q.poll();

            if (!values[i].equals("null")) {
                parent.left = new Node7(Integer.parseInt(values[i]));
                q.add(parent.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")) {
                parent.right = new Node7(Integer.parseInt(values[i]));
                q.add(parent.right);
            }
            i++;
        }
        return root;
    }

    // Inorder traversal (for verification)
    public void inorder(Node7 node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeSerialize tree = new BinaryTreeSerialize();

        // Build tree manually
        tree.root = new Node7(10);
        tree.root.left = new Node7(20);
        tree.root.right = new Node7(30);
        tree.root.left.left = new Node7(40);
        tree.root.left.right = new Node7(50);

        // Serialize
        String serialized = tree.serialize(tree.root);
        System.out.println("Serialized Tree: " + serialized);

        // Deserialize
        Node7 newRoot = tree.deserialize(serialized);
        System.out.print("Inorder after Deserialize: ");
        tree.inorder(newRoot);
    }
}

//Serialized Tree: 10,20,30,40,50,null,null,null,null,null,null,
//Inorder after Deserialize: 40 20 50 10 30 