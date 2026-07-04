package revision12;

class TreeNode14 {

    int data;
    TreeNode14 left,right;

    TreeNode14(int data){
        this.data=data;
    }
}

public class DiameterTree{

    static int diameter=0;

    static int height(TreeNode14 root){

        if(root==null)
            return 0;

        int left=height(root.left);
        int right=height(root.right);

        diameter=Math.max(
                diameter,
                left+right);

        return Math.max(left,right)+1;
    }

    public static void main(String[] args){

        TreeNode14 root=new TreeNode14(1);

        root.left=new TreeNode14(2);
        root.right=new TreeNode14(3);

        root.left.left=new TreeNode14(4);
        root.left.right=new TreeNode14(5);

        height(root);

        System.out.println(diameter);
    }
}
