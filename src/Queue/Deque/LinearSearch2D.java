package Queue.Deque;


/*
Problem 8 – Search in a 2D Array

Description:
You are given a 2D array (matrix) of integers. Write a
method using linear search to check whether a given target exists in the matrix.
Return true if found, otherwise false.

Matrix:
1   4   7
8   10  12
13  15  20

Target: 10
Output: true

Target: 9
Output: false


Logic Explanation
1.In a 2D array, elements are stored in rows and columns.
2.Linear search means we scan each element one by one.
3.We loop through every row, and inside each row, loop through every column.
4.If an element matches the target, return true.
5.If after scanning all elements we don’t find the target, return false.

 */

public class LinearSearch2D {
    public static boolean search2D(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) { // loop through rows
            for (int col = 0; col < matrix[row].length; col++) { // loop through columns
                if (matrix[row][col] == target) {
                    return true; // target found
                }
            }
        }
        return false; // target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7},
                {8, 10, 12},
                {13, 15, 20}
        };

        int target1 = 10;
        int target2 = 9;

        System.out.println("Target " + target1 + " found: " + search2D(matrix, target1));
        System.out.println("Target " + target2 + " found: " + search2D(matrix, target2));
    }
}

//Target 10 found: true
//Target 9 found: false

/*
Dry Run (Target = 10)

Matrix:

Row 0 → 1  → not match
       4  → not match
       7  → not match
Row 1 → 8  → not match
      10  → match found → return true

 */