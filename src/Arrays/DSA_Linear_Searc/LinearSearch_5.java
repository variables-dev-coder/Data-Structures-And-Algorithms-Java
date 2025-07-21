package Arrays.DSA_Linear_Searc;


// Find First and Last Occurrence of an Element
// Given an array and a target, find the first and last index where the element occurs.

public class LinearSearch_5 {
    public static void findFirstAndLastElement(int[] arr, int target) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1) {
                    first = i;     // first time we found it
                }
                last = i;    // always update last
            }
        }

        if (first != -1) {
            System.out.println("First Occurrence: " + first);
            System.out.println("Last Occurrence: " + last);
        } else {
            System.out.println("Element not found!");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 5, 9, 10};
        int target = 5;

        findFirstAndLastElement(arr, target);
    }
}
