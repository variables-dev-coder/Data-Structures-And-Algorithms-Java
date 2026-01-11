package Trees.Binary_Search_Tree_BST.revision;

public class SquareRootBinarySearch {

    public static int mySqrt(int x) {

        if (x < 2) return x;

        int low = 1, high = x / 2;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long square = (long) mid * mid; // avoid overflow

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;        // store possible answer
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // Main method
    public static void main(String[] args) {

        int x = 8;

        int sqrt = mySqrt(x);

        System.out.println("Integer square root of " + x + " is: " + sqrt);
    }
}

