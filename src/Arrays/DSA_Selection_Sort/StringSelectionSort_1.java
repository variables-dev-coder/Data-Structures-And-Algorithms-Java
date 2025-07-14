package Arrays.DSA_Selection_Sort;

public class StringSelectionSort_1 {
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "pear", "orange", "grape"};

        System.out.println("Original Array:");
        printArray(words);

        for (int i = 0; i < words.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].compareTo(words[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // swap
            String temp = words[minIndex];
            words[minIndex] = words[i];
            words[i] = temp;
        }
        System.out.println("\nSorted Words:");
        printArray(words);
    }
    public static void printArray(String[] arr) {
        for (String word : arr) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}
