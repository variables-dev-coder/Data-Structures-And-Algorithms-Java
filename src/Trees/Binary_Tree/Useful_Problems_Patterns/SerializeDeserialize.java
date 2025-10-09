package Trees.Binary_Tree.Useful_Problems_Patterns;


/*
Concept — What Is Serialization & Deserialization?
Serialization → Convert a binary tree into a string (or array)
Deserialization → Convert that string back into the original tree

Why needed?
To save the tree in a file or send it across a network
To reconstruct the same structure later

Example Tree
        1
       / \
      2   3
         / \
        4   5

Serialized Form (Preorder with null markers):

"1,2,null,null,3,4,null,null,5,null,null"

Approach 1: Preorder Traversal (Recursive)
Idea:
Use preorder traversal (root → left → right)
Represent null with "null"
Use a delimiter , between nodes

 */

import java.util.*;

class TreeNode7 {
    int val;
    TreeNode7 left, right;

    TreeNode7(int val) {
        this.val = val;
    }
}

public class SerializeDeserialize {

    // Serialize using preorder traversal
    public String serialize(TreeNode7 root) {
        if (root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Deserialize string to tree
    public TreeNode7 deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return buildTree(queue);
    }

    private TreeNode7 buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        TreeNode7 node = new TreeNode7(Integer.parseInt(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }

    public static void main(String[] args) {
        // Construct a binary tree
        TreeNode7 root = new TreeNode7(1);
        root.left = new TreeNode7(2);
        root.right = new TreeNode7(3);
        root.right.left = new TreeNode7(4);
        root.right.right = new TreeNode7(5);

        SerializeDeserialize codec = new SerializeDeserialize();

        // Serialize
        String serialized = codec.serialize(root);
        System.out.println("Serialized Tree: " + serialized);

        // Deserialize
        TreeNode7 deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized Root Value: " + deserialized.val);
    }
}

/*
Serialized Tree: 1,2,null,null,3,4,null,null,5,null,null,
Deserialized Root Value: 1

Dry Run

serialize(1)
 → "1," + serialize(2) + serialize(3)
serialize(2)
 → "2," + serialize(null) + serialize(null)
 → "2,null,null,"
serialize(3)
 → "3," + serialize(4) + serialize(5)
serialize(4)
 → "4,null,null,"
serialize(5)
 → "5,null,null,"
Combine → "1,2,null,null,3,4,null,null,5,null,null,"

When deserializing:
Read value by value using queue
Reconstruct recursively

 */
