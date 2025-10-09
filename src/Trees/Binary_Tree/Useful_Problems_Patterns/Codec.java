package Trees.Binary_Tree.Useful_Problems_Patterns;

//Approach 2: Level Order (Iterative)
//Idea:
//Use BFS to build the string level by level.
//Code Example (Level-order Serialize/Deserialize)



import java.util.*;

class Codec {
    // Serialize using BFS
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }

        return sb.toString();
    }

    // Deserialize BFS string back to tree
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;
            if (i < values.length && !values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();

        String data = codec.serialize(root);
        System.out.println("Serialized: " + data);

        TreeNode node = codec.deserialize(data);
        System.out.println("Deserialized Root: " + node.val);
    }
}

//Serialized: 1,2,3,null,null,4,5,null,null,null,null,
//Deserialized Root: 1

/*
Complexity

| Operation       | Time | Space |
| --------------- | ---- | ----- |
| Serialization   | O(n) | O(n)  |
| Deserialization | O(n) | O(n)  |

Takeaway
Preorder (recursive) is most common & simple
Level-order (BFS) is iterative and used in many interview variations
Helps in problems like:
    Cloning trees
    Persisting data structures
    Sending trees between microservices
    
 */