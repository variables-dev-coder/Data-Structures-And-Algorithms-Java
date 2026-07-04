package revision12;

class TreeNode17 {

    int data;
    TreeNode17 left,right;

    TreeNode17(int data){
        this.data=data;
    }
}

public class MaximumDepth{

    static int maxDepth(TreeNode17 root){

        if(root==null)
            return 0;

        return Math.max(
                maxDepth(root.left),
                maxDepth(root.right)
        )+1;
    }

    public static void main(String[] args){

        TreeNode17 root=new TreeNode17(3);

        root.left=new TreeNode17(9);

        root.right=new TreeNode17(20);

        root.right.left=new TreeNode17(15);
        root.right.right=new TreeNode17(7);

        System.out.println(
                maxDepth(root)
        );
    }
}
