package Revision.Day_2_Recursion_Backtracking;


// Check middle element
//If key < mid → search left
//If key > mid → search right
//If key == mid → return index

public class BinarySearchRecursive {

    static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;

        if (arr[mid] == key) return mid;
        if (key < arr[mid]) return binarySearch(arr, low, mid - 1, key);
        return binarySearch(arr, mid + 1, high, key);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int key = 7;
        int result = binarySearch(arr, 0, arr.length - 1, key);
        System.out.println("Found at index: " + result);
    }
}

/*
mid=2 (5) → key>5 → search right  
mid=4 (9) → key<9 → search left
mid=3 (7) → found

 */