package Trees.Binary_Search_Tree_BST.day7_BuildBSTSortedArray;


class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
    }
}

public class Day7SortedArrayToBST {

    // Build BST from sorted array
    static Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2; // middle element
        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);  // left half
        root.right = sortedArrayToBST(arr, mid + 1, end);   // right half

        return root;
    }

    // Traversal to verify tree structure
    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        Node root = sortedArrayToBST(arr, 0, arr.length - 1);

        System.out.println("Inorder (Sorted Output): ");
        inorder(root);

        System.out.println("\nPreorder (Tree Structure): ");
        preorder(root);
    }
}

//Inorder (Sorted Output):
//10 20 30 40 50 60 70
//Preorder (Tree Structure):
//40 20 10 30 60 50 70 