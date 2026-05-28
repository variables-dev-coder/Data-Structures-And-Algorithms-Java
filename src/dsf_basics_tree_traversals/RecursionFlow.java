package dsf_basics_tree_traversals;

public class RecursionFlow {

    static void solve(int n) {

        if (n == 0) {
            return;
        }

        System.out.println("Entering: " + n);

        solve(n - 1);

        System.out.println("Returning: " + n);
    }

    public static void main(String[] args) {

        solve(3);
    }
}
