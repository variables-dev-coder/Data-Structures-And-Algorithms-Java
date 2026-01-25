package Trees.Tree_Construction.day04_Tree_Transformation;

public class CheckMirrorTrees {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        /*
           Tree 1:            Tree 2:
                1                 1
              /   \             /   \
             2     3           3     2
            /                       \
           4                         4
         */

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(2);
        t2.right.right = new TreeNode(4);

        System.out.println("Are mirrors? " + isMirror(t1, t2));
    }
}

// Are mirrors? true