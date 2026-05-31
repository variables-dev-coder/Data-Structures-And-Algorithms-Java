package revision7;

class NodeLCA {

    int data;
    NodeLCA left;
    NodeLCA right;

    NodeLCA(int data) {
        this.data = data;
    }
}

public class LowestCommonAncestor {

    static NodeLCA lca(NodeLCA root, int p, int q) {

        if (root == null) {
            return null;
        }

        if (root.data == p || root.data == q) {
            return root;
        }

        NodeLCA left = lca(root.left, p, q);
        NodeLCA right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {

        NodeLCA root = new NodeLCA(1);

        root.left = new NodeLCA(2);
        root.right = new NodeLCA(3);

        root.left.left = new NodeLCA(4);
        root.left.right = new NodeLCA(5);

        NodeLCA ans = lca(root, 4, 5);

        System.out.println("LCA = " + ans.data);
    }
}
