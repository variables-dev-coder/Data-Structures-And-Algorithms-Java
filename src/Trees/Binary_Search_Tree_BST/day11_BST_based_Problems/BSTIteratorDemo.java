package Trees.Binary_Search_Tree_BST.day11_BST_based_Problems;

import java.util.Stack;

class Node4 {
    int val;
    Node4 left, right;

    Node4(int val) {
        this.val = val;
    }
}

class BSTIterator {
    Stack<Node4> stack = new Stack<>();

    BSTIterator(Node4 root) {
        pushLeft(root);
    }

    void pushLeft(Node4 node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    int next() {
        Node4 node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }
}

public class BSTIteratorDemo {

    public static void main(String[] args) {
        Node4 root = new Node4(20);
        root.left = new Node4(10);
        root.right = new Node4(30);
        root.left.left = new Node4(5);
        root.left.right = new Node4(15);

        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        // Output: 5 10 15 20 30
    }
}
