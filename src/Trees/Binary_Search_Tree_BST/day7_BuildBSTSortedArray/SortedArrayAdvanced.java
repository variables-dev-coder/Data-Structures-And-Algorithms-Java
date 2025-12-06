package Trees.Binary_Search_Tree_BST.day7_BuildBSTSortedArray;


class Node2 {
    int key;
    Node2 left, right;

    Node2(int key) {
        this.key = key;
    }
}

public class SortedArrayAdvanced {

    static Node2 sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        Node2 root = new Node2(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    static void inorder(Node2 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
    }

    static void preorder(Node2 root) {
        if (root == null) return;
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(Node2 root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key + " ");
    }

    static void levelOrder(Node2 root) {
        if (root == null) return;

        java.util.Queue<Node2> q = new java.util.LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node2 curr = q.poll();
            System.out.print(curr.key + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    static int height(Node2 root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        Node2 root = sortedArrayToBST(arr, 0, arr.length - 1);

        System.out.println("Inorder:");
        inorder(root);

        System.out.println("\nPreorder:");
        preorder(root);

        System.out.println("\nPostorder:");
        postorder(root);

        System.out.println("\nLevel Order:");
        levelOrder(root);

        System.out.println("\nHeight: " + height(root));
    }
}

//Inorder:
//10 20 40
//Preorder:
//40 20 10 30 60 50 70
//Postorder:
//10 30 20 50 70 60 40
//Level Order:
//40 20 60 10 30 50 70
//Height: 3