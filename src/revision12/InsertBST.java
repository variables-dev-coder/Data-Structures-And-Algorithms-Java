package revision12;

class TreeNode7 {

    int data;
    TreeNode7 left;
    TreeNode7 right;

    TreeNode7(int data) {
        this.data = data;
    }
}

public class InsertBST {

    static TreeNode7 insert(TreeNode7 root, int value) {

        if(root == null)
            return new TreeNode7(value);

        if(value < root.data)
            root.left = insert(root.left, value);

        else
            root.right = insert(root.right, value);

        return root;
    }

    static void inorder(TreeNode7 root){

        if(root==null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args){

        TreeNode7 root = null;

        root = insert(root,50);
        root = insert(root,30);
        root = insert(root,70);
        root = insert(root,20);
        root = insert(root,40);
        root = insert(root,60);
        root = insert(root,80);

        inorder(root);
    }
}
