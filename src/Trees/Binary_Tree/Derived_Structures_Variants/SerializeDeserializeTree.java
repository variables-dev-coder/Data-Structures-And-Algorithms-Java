package Trees.Binary_Tree.Derived_Structures_Variants;

import java.util.*;

class Node4 {
    int val;
    Node4 left, right;

    Node4(int val) {
        this.val = val;
    }
}

public class SerializeDeserializeTree {

    //  Serialize (Preorder traversal)
    static String serialize(Node4 root) {
        if (root == null)
            return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    //  Deserialize (Rebuild using recursion)
    static Node4 deserialize(Queue<String> nodes) {
        if (nodes.isEmpty())
            return null;

        String val = nodes.poll();
        if (val.equals("null"))
            return null;

        Node4 root = new Node4(Integer.parseInt(val));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    static Node4 deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue);
    }

    // Utility inorder print
    static void inorder(Node4 root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
                 / \
                4   5
        */
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(3);
        root.right.left = new Node4(4);
        root.right.right = new Node4(5);

        // Serialize
        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        // Deserialize
        Node4 newRoot = deserialize(serialized);
        System.out.print("Inorder after deserialization: ");
        inorder(newRoot);
    }
}

//Serialized: 1,2,null,null,3,4,null,null,5,null,null,
//Inorder after deserialization: 2 1 4 3 5

/*
Dry Run
Step 1: Serialize with preorder

visit(1) → "1,"
visit(2) → "2,"
  left=null → "null,"
  right=null → "null,"
visit(3) → "3,"
visit(4) → "4,null,null,"
visit(5) → "5,null,null,"

Final String:

1,2,null,null,3,4,null,null,5,null,null,

Step 2: Deserialize recursively

Read values in preorder order.

When you see "null", return null.

Build left → then right subtree.

Reconstructed tree is identical to original.

Complexity

Time: O(n) → both serialization & deserialization

Space: O(n) → for recursion + string storage

 */