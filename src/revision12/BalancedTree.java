package revision12;

class TreeNode18 {

    int data;
    TreeNode18 left,right;

    TreeNode18(int data){
        this.data=data;
    }
}

public class BalancedTree{

    static int check(TreeNode18 root){

        if(root==null)
            return 0;

        int left=check(root.left);

        if(left==-1)
            return -1;

        int right=check(root.right);

        if(right==-1)
            return -1;

        if(Math.abs(left-right)>1)
            return -1;

        return Math.max(left,right)+1;
    }

    static boolean isBalanced(TreeNode18 root){

        return check(root)!=-1;
    }

    public static void main(String[] args){

        TreeNode18 root=new TreeNode18(1);

        root.left=new TreeNode18(2);
        root.right=new TreeNode18(3);

        root.left.left=new TreeNode18(4);
        root.left.right=new TreeNode18(5);

        System.out.println(
                isBalanced(root)
        );
    }
}
