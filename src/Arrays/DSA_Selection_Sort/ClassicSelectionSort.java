package Arrays.DSA_Selection_Sort;

public class ClassicSelectionSort {
    public static void main(String[] args) {
        int[] numbers = {29, 10, 14, 37, 13};

        System.out.println("Original Array:");
        printArray(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            // swap
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[i];
            numbers[i] = temp;
        }
        System.out.println("\nSorted Array:");
        printArray(numbers);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
