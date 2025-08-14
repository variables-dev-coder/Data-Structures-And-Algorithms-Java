package Queue.Deque;


/*

Problem 5 – Search in a 2D Array

Description:
Given a 2D integer array (matrix) and a target value, write a program using
Linear Search to check if the target exists in the matrix. If found, print its position
(row and column), otherwise print "Not Found".

Example Input:
matrix = [
  [10, 20, 30],
  [40, 50, 60],
  [70, 80, 90]
]
target = 50

Example Output:
Found at Row: 1, Column: 1

Logic Explanation:
1.Loop through each row of the matrix.
2.Inside each row, loop through each column element.
3.Compare each element with the target.
4.If match found → print position and stop.
5.If the loop ends without finding → print "Not Found".
 */


public class Search2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90}
        };
        int target = 50;
        boolean found = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    System.out.println("Found at Row: " + row + ", Column: " + col);
                    found = true;
                    break; // Break from inner loop
                }
            }
            if (found) break; // Break from outer loop
        }

        if (!found) {
            System.out.println("Not Found");
        }
    }
}

// Found at Row: 1, Column: 1

/*
Dry Run (target = 50)
Row 0 → Check 10, 20, 30 → No match
Row 1 → Check 40 → No match → Check 50 → Match found at (1,1) → print result → stop search

 */