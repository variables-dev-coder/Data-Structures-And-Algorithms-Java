package Trees.Binary_Tree.Day01_Full_Binary_Tree;


//Q: How do you check if a Binary Tree is a Full Binary Tree?
//A: A binary tree is full if every node has either 0 or 2 children.

class Node4 {
    int data;
    Node4 left, right;


    Node4(int data) {
        this.data = data;
        left = right = null;
    }
}

public class FullBinaryTreeCheck {
    // Function to check Full Binary Tree
    static boolean isFull(Node4 root) {
        if (root == null) return true;  // Empty tree is full

        // Leaf node
        if (root.left == null && root.right == null) return true;

        // If both children exist → check recursively
        if (root.left != null && root.right != null)
            return isFull(root.left) && isFull(root.right);

        // One child only → Not full
        return false;
    }

    public static void main(String[] args) {
        Node4 root = new Node4(10);
        root.left = new Node4(20);
        root.right = new Node4(30);
        root.left.left = new Node4(40);
        root.left.right = new Node4(50);

        if (isFull(root))
            System.out.println("Full Binary Tree");
        else
            System.out.println("Not Full Binary Tree");
    }

}

// Not Full Binary Tree

/*
Dry Run:

Root(10) → has 2 children → ok

Node(20) → has 2 children → ok

Node(30) → only left & right missing → break rule → Not Full

 */