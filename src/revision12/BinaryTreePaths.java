package revision12;

class TreeNode15 {

    int data;
    TreeNode15 left,right;

    TreeNode15(int data){
        this.data=data;
    }
}

public class BinaryTreePaths{

    static void paths(TreeNode15 root,
                      String path){

        if(root==null)
            return;

        path += root.data;

        if(root.left==null &&
                root.right==null){

            System.out.println(path);
            return;
        }

        path+="->";

        paths(root.left,path);
        paths(root.right,path);
    }

    public static void main(String[] args){

        TreeNode15 root=new TreeNode15(1);

        root.left=new TreeNode15(2);
        root.right=new TreeNode15(3);

        root.left.right=new TreeNode15(5);

        paths(root,"");
    }
}
