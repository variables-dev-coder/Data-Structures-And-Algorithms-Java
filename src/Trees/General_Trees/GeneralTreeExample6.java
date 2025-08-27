package Trees.General_Trees;

public class GeneralTreeExample6 {
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");

        A.addChild(B);
        A.addChild(C);
        A.addChild(D);
        C.addChild(E);

        printTree(A, "");
    }

    static void printTree(TreeNode node, String space) {
        System.out.println(space + node.data);
        for (TreeNode child : node.children) {
            printTree(child, space + "   ");
        }
    }
}

/*
A
   B
   C
      E
   D

How it works internally
    Node A has a list → [B, C, D]
    Node C has a list → [E]
    Node B, D, E → empty list []
    Traversal just recursively prints each node and its children.




What is a General Tree?
Each node can have any number of children (not just 2 like in a Binary Tree).
We usually represent children using a list/array inside each node.

Tree Node Structure (Java Example)

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    List<TreeNode> children; // each node can have multiple children

    TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>(); // empty list initially
    }

    void addChild(TreeNode child) {
        children.add(child);
    }
}


Example 1 – Simple Family Tree
         A
       / | \
      B  C  D
         |
         E



 */