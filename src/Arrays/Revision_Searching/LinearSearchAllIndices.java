package Arrays.Revision_Searching;

public class LinearSearchAllIndices {
    public static void linearSearch(int[] arr, int key) {
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Key found at index: " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("key not found in the array");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 5, 2, 3, 7, 2, 9, 5, 2, 7, 8, 2, 10, 10, 2,};

        int key = 2;

        linearSearch(arr, key);
    }
}


/*
Logic

Traverse the array from 0 to n-1.
Compare each element with the key.
If a match is found, store/print the index.
If no match is found, display “Element not found.”


Key found at index: 1
Key found at index: 3
Key found at index: 5
Key found at index: 8
Key found at index: 11
Key found at index: 14
Key found at index: 17

 */