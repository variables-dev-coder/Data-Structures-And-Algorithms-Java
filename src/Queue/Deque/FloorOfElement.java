package Queue.Deque;


/*
Description:
Given a sorted array of integers (ascending order) and a target value x, find the floor of x.
The floor of x is the largest element in the array less than or equal to x.
If no such element exists, return -1.


ex
arr = [2, 4, 6, 8, 10, 12]
x = 7

6

Explanation:
6 is the largest number less than or equal to 7.

ex
arr = [1, 3, 5, 7, 9]
x = 0

-1

Explanation:
No element is less than or equal to 0.

Logic & Approach (Binary Search)
We use binary search to find the floor efficiently in O(log n) time.
Steps:
1.Initialize low = 0, high = arr.length - 1, and ans = -1.
2.While low <= high:
    Find mid = low + (high - low) / 2.
    If arr[mid] == x → return arr[mid] (perfect floor).
    If arr[mid] < x → store arr[mid] in ans (potential floor) and move right (low = mid + 1).
    Else → move left (high = mid - 1).
3.Return ans.

 */
public class FloorOfElement {
    public static int findFloor(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return arr[mid]; // Exact match is the floor
            } else if (arr[mid] < x) {
                ans = arr[mid]; // Potential floor
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6, 8, 10, 12};
        int x1 = 7;
        System.out.println("Floor of " + x1 + " is: " + findFloor(arr1, x1)); // 6

        int[] arr2 = {1, 3, 5, 7, 9};
        int x2 = 0;
        System.out.println("Floor of " + x2 + " is: " + findFloor(arr2, x2)); // -1
    }
}

/*
Floor of 7 is: 6
Floor of 0 is: -1
 */

/*
Dry Run (Example 1)
arr = [2, 4, 6, 8, 10, 12], x = 7
low=0, high=5 → mid=2 → arr[mid]=6 < 7 → ans=6 → low=3
low=3, high=5 → mid=4 → arr[mid]=10 > 7 → high=3
low=3, high=3 → mid=3 → arr[mid]=8 > 7 → high=2 → loop ends.

Answer: 6

 */