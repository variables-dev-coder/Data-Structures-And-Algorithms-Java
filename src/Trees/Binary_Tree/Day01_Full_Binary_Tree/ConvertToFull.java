package Trees.Binary_Tree.Day01_Full_Binary_Tree;


//Convert Any Binary Tree to Full Binary Tree
//Sometimes asked in interviews: “Can you prune the tree so that it becomes full?”


public class ConvertToFull {
    static Node convert(Node root) {
        if (root == null) return null;

        root.left = convert(root.left);
        root.right = convert(root.right);

        // If one child is missing → replace with the existing child
        if (root.left == null && root.right != null) return root.right;
        if (root.right == null && root.left != null) return root.left;

        return root;
    }
}

/*


Explanation:
If a node has only one child, remove that node and attach the existing child upwards.

 */