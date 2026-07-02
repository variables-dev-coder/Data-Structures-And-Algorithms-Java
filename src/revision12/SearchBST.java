package revision12;

class TreeNode6 {

    int data;
    TreeNode6 left;
    TreeNode6 right;

    TreeNode6(int data) {
        this.data = data;
    }
}

public class SearchBST {

    static TreeNode6 search(TreeNode6 root, int key) {

        if (root == null || root.data == key)
            return root;

        if (key < root.data)
            return search(root.left, key);

        return search(root.right, key);
    }

    public static void main(String[] args) {

        TreeNode6 root = new TreeNode6(50);

        root.left = new TreeNode6(30);
        root.right = new TreeNode6(70);

        root.left.left = new TreeNode6(20);
        root.left.right = new TreeNode6(40);

        root.right.left = new TreeNode6(60);
        root.right.right = new TreeNode6(80);

        TreeNode6 result = search(root, 60);

        if(result != null)
            System.out.println("Found : " + result.data);
        else
            System.out.println("Not Found");
    }
}
