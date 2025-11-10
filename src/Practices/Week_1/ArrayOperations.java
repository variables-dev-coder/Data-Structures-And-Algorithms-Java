package Practices.Week_1;

import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        // Access elements

        System.out.println("First element: " + numbers[0]);  // First element: 10
        System.out.println("Last element: " + numbers[numbers.length - 1]);  // Last element: 50

        // Modify element
        numbers[2] = 35;
        System.out.println("Modify arrays: " + Arrays.toString(numbers)); // Modify arrays: [10, 20, 35, 40, 50]

        // Iterate through array
        System.out.println("using for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        System.out.println("Using enhance for loop:");
        for (int num : numbers) {
            System.out.println("Element: " + num);
        }
    }
}


/*

First element: 10
Last element: 50
Modify arrays: [10, 20, 35, 40, 50]
using for loop:
Index 0: 10
Index 1: 20
Index 2: 35
Index 3: 40
Index 4: 50
Using enhance for loop:
Element: 10
Element: 20
Element: 35
Element: 40
Element: 50

 */