package Trees.Binary_Tree;

public class Notes {
    public static void main(String[] args) {
        /*

Binary Tree – Theory
1. Definition

A Binary Tree is a tree data structure where each node has at most 2 children:
    Left child
    Right child

This restriction makes it simpler than a general tree.



2. Basic Terminology

    Root → Topmost node of the tree.
    Parent → A node that has children.
    Child → A node that descends from a parent.
    Leaf → A node with no children.
    Siblings → Nodes that share the same parent.
    Depth (Level) → Distance of a node from the root.
    Height → Max depth of the tree.


3. Properties of Binary Tree

1.Maximum number of nodes at level l = 2^l
    Level 0 → 1 node (root)
    Level 1 → 2 nodes
    Level 2 → 4 nodes
    Level k → 2^k nodes
2.Maximum number of nodes in a binary tree of height h = 2^(h+1) - 1
3.Minimum possible height for n nodes = log₂(n+1) - 1


4. Types of Binary Trees

1.Full Binary Tree
    Every node has 0 or 2 children.

2.Complete Binary Tree
    All levels are filled except possibly the last, and last level nodes are filled from left to right.

3.Perfect Binary Tree
    All internal nodes have 2 children, and all leaf nodes are at the same level.

4.Skewed Binary Tree
    Tree behaves like a linked list.
    Left-skewed → All nodes have only left child.
    Right-skewed → All nodes have only right child.

5.Balanced Binary Tree
    Height difference between left & right subtrees of every node is at most 1.


5. Applications of Binary Trees

    Expression parsing (Compilers, calculators)
    Routing tables in networks
    Hierarchical data (organization charts, file systems)
    Foundation for Binary Search Trees (BST), Heaps, and Priority Queues



         */
    }
}
