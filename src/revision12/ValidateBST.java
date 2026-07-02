package revision12;

class TreeNode8 {

    int data;
    TreeNode8 left;
    TreeNode8 right;

    TreeNode8(int data){
        this.data=data;
    }
}

public class ValidateBST {

    static boolean isValid(TreeNode8 root,
                           long min,
                           long max){

        if(root==null)
            return true;

        if(root.data<=min || root.data>=max)
            return false;

        return isValid(root.left,min,root.data)
                &&
                isValid(root.right,root.data,max);
    }

    public static void main(String[] args){

        TreeNode8 root=new TreeNode8(50);

        root.left=new TreeNode8(30);
        root.right=new TreeNode8(70);

        root.left.left=new TreeNode8(20);
        root.left.right=new TreeNode8(40);

        root.right.left=new TreeNode8(60);
        root.right.right=new TreeNode8(80);

        System.out.println(
                isValid(root,
                        Long.MIN_VALUE,
                        Long.MAX_VALUE)
        );
    }
}
