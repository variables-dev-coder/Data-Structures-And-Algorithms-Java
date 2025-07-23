package Arrays.Revesion_Sorting_Searching_Day01;


// Given an array and a target element, count how many times the target appears.

public class CountFrequency {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 2, 3, 4, 1, 3, 3, 6, 7, 2, 3, 4, 3,2, 4};
        int target = 2;
        int count = 0;

        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }
        System.out.println("Frequency of " + target + " = " + count);
    }
}
