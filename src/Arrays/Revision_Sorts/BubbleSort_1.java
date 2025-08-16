package Arrays.Revision_Sorts;

/*
Bubble Sort
Idea:
Repeatedly swap adjacent elements if they are in the wrong order.
Like bubbles in water, the largest elements "bubble up" to the end after each pass.

Process:
Compare element arr[j] with arr[j+1].
If arr[j] > arr[j+1], swap them.
After 1st pass → largest element goes to the last position.
Repeat until array is sorted.

🔹 Example
Array: [5, 3, 8, 4, 2]
Pass 1:
[3, 5, 4, 2, 8] → 8 bubbled to last.
Pass 2:
[3, 4, 2, 5, 8]
Pass 3:
[3, 2, 4, 5, 8]
Pass 4:
[2, 3, 4, 5, 8] Sorted.
 */


public class BubbleSort_1 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Optimization: stop if no swap happened
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        bubbleSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

// 2 3 4 5 8

/*
Complexity

Best Case (already sorted): O(n)
Worst Case: O(n²)
Space Complexity: O(1) → In-place
Stability: Yes (preserves order of equal elements)



 */