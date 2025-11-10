package Practices.Week_1;

public class ArraysBasics {
    public static void main(String[] args) {
        // Different ways to declare arrays

        int[] arr1; // Declaration
        arr1 = new int[5];  // Instantiation

        int[] arr2 = new int[5];  // Declaration + Instantiation
        int[] arr3 = {1, 2, 3, 4, 5};   // Declaration + Initialization

        // Multi-dimensional arrays

        int[][] matrix = new int[3][3];
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Arrays Length: " + arr3.length);  // Arrays Length: 5
    }
}
