package revision7;

class Node19 {

    int data;
    Node19 left, right;

    Node19(int data) {
        this.data = data;
    }
}

public class IdenticalTrees {

    static boolean isSame(
            Node19 p,
            Node19 q) {

        if (p == null &&
                q == null)
            return true;

        if (p == null ||
                q == null)
            return false;

        return p.data == q.data
                && isSame(
                p.left,
                q.left)
                && isSame(
                p.right,
                q.right);
    }

    public static void main(String[] args) {

        Node19 a = new Node19(1);
        a.left = new Node19(2);

        Node19 b = new Node19(1);
        b.left = new Node19(2);

        System.out.println(
                isSame(a, b));
    }
}
