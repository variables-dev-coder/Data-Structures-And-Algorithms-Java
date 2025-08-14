package Queue.Deque;


/*
Problem 7 – Find the Index of the Last Occurrence of an Element in an Array
Problem Statement

Given an array of integers and a target element, find the index of the last
occurrence of the target in the array. If the target is not present, return -1.

ex
Array: [5, 2, 7, 2, 9, 2, 4]
Target: 2

5

Explanation:
The element 2 occurs at indices 1, 3, and 5. The last occurrence is at index 5.
Logic Explanation
Start from index 0 and iterate through the array.
Keep a variable lastIndex initialized to -1.
Each time you find the target, update lastIndex with the current index.
At the end of the loop, lastIndex will contain the position of the last occurrence,
r -1 if the element is not found.

 */
public class LastOccurrenceLinearSearch {
    public static int findLastOccurrence(int[] arr, int target) {
        int lastIndex = -1; // Default value if element not found

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                lastIndex = i; // Update last index when target found
            }
        }

        return lastIndex;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 2, 9, 2, 4};
        int target = 2;

        int result = findLastOccurrence(arr, target);
        if (result != -1) {
            System.out.println("Last occurrence of " + target + " is at index: " + result);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}

/*
Dry Run

Array: [5, 2, 7, 2, 9, 2, 4]
Target: 2

| i | arr\[i] | Match? | lastIndex |
| - | ------- | ------ | --------- |
| 0 | 5       | No     | -1        |
| 1 | 2       | Yes    | 1         |
| 2 | 7       | No     | 1         |
| 3 | 2       | Yes    | 3         |
| 4 | 9       | No     | 3         |
| 5 | 2       | Yes    | 5         |
| 6 | 4       | No     | 5         |

Final Answer: 5
 */