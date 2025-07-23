package Arrays.Revesion_Sorting_Searching_Day01;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 3, 7, 3, 9, 10};
        int target = 3;
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (first == -1)
                    first = i;
                last = i;
            }
        }

        System.out.println("First Occurrence of " + target + " = " + first);
        System.out.println("Last Occurrence of " + target + " = " + last);
    }
}
