package Arrays.Revesion_Sorting_Searching_Day02;

public class StringInsertionSort {
    public static void main(String[] args) {
        String[] arr = {"banana", "apple", "cherry", "date"};

        for (int i = 1; i < arr.length; i++) {
            String current = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(current) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        for (String str : arr)
            System.out.print(str + " ");
        System.out.println();
    }
}
