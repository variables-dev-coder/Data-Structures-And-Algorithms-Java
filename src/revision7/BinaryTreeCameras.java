package revision7;

class Node29 {

    int data;
    Node29 left;
    Node29 right;

    Node29(int data) {
        this.data = data;
    }
}

public class BinaryTreeCameras {

    static int cameras = 0;

    // 0 = needs camera
    // 1 = has camera
    // 2 = covered

    static int dfs(Node29 root) {

        if (root == null) {
            return 2;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        // child needs camera
        if (left == 0 || right == 0) {

            cameras++;

            return 1;
        }

        // child has camera
        if (left == 1 || right == 1) {

            return 2;
        }

        // needs camera
        return 0;
    }

    static int minCameraCover(Node29 root) {

        if (dfs(root) == 0) {

            cameras++;
        }

        return cameras;
    }

    public static void main(String[] args) {

        Node29 root = new Node29(0);

        root.left = new Node29(0);

        root.left.left = new Node29(0);
        root.left.right = new Node29(0);

        System.out.println(
                minCameraCover(root));
    }
}
