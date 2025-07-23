package Arrays.Revesion_Sorting_Searching_Day01;

public class FindMaxMin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6,};
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("Maximum Value: " + max);
        System.out.println("Minimum Value: " + min);
    }
}
