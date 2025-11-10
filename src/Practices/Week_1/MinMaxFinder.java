package Practices.Week_1;

public class MinMaxFinder {

    public static int findMin(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int[] findMinMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1, 8, 5};

        System.out.println("Minimum: " + findMin(numbers));
        System.out.println("Maximum: " + findMax(numbers));

        int[] minMax = findMinMax(numbers);
        System.out.println("Min: " + minMax[0] + ", Max: " + minMax[1]);
    }
}

//Minimum: 1
//Maximum: 9
//Min: 1, Max: 9