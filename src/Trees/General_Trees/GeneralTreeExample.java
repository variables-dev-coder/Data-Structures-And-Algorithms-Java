package Trees.General_Trees;



import java.util.ArrayList;
import java.util.List;

// Node structure for General Tree
class TreeNode {
    String data;
    List<TreeNode> children;  // list of children

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    // Add child node
    public void addChild(TreeNode child) {
        children.add(child);
    }
}

// Main Class
public class GeneralTreeExample {
    public static void main(String[] args) {
        // Create root
        TreeNode root = new TreeNode("A");

        // Create children of root
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");

        root.addChild(b);
        root.addChild(c);
        root.addChild(d);

        // Add children to B
        b.addChild(new TreeNode("E"));
        b.addChild(new TreeNode("F"));

        // Add children to C
        c.addChild(new TreeNode("G"));

        // Add children to D
        d.addChild(new TreeNode("H"));
        d.addChild(new TreeNode("I"));
        d.addChild(new TreeNode("J"));

        // Print the tree (DFS style)
        printTree(root, " ");
    }

    // Recursive function to print tree
    public static void printTree(TreeNode node, String space) {
        if (node == null) return;

        System.out.println(space + node.data);

        for (TreeNode child : node.children) {
            printTree(child, space + "   ");
        }
    }
}

/*
 A
    B
       E
       F
    C
       G
    D
       H
       I
       J

 */