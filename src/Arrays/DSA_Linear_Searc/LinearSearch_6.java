package Arrays.DSA_Linear_Searc;


// Search in a 2D Array using Linear Search
// Search for a target element in a 2D array using linear search. If found, print its row and column index.

public class LinearSearch_6 {

    public static void search2D(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    System.out.println("Element found at Row: " + row + ", col: " + col);
                    return;
                }
            }
        }
        System.out.println("Element not found!");
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target = 6;

        search2D(matrix, target);
    }
}
