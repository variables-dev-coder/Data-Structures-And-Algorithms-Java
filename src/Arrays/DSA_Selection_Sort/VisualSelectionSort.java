package Arrays.DSA_Selection_Sort;

public class VisualSelectionSort {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {15, 3, 8, 20, 5, 1, 17};

        System.out.println("Original Array:");
        printArray(arr);
        System.out.println();

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("Pass " + (i + 1) + ":");
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                printCurrentComparison(arr, i, j, minIdx);
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
                Thread.sleep(1000); // Pause for visualization
            }

            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            System.out.println("After swap:");
            printArray(arr);
            System.out.println();
        }
    }

    public static void printCurrentComparison(int[] arr, int i, int j, int minIdx) {
        for (int k = 0; k < arr.length; k++) {
            if (k == i) System.out.print("[" + arr[k] + "] ");
            else if (k == j) System.out.print(">" + arr[k] + "< ");
            else if (k == minIdx) System.out.print("(" + arr[k] + ") ");
            else System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
