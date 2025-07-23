package Arrays.Revesion_Sorting_Searching_Day01;

public class FloorCeil {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10, 12, 14};   // Sorted Array
        int target = 7;
        int floor = -1;
        int ceil = -1;

        for (int num : arr) {
            if (num <= target)
                floor = num;
            if (num >= target && ceil == -1)
                ceil = num;
        }

        System.out.println("Floor of " + target + " = " + floor);
        System.out.println("Ceil of " + target + " = " + ceil);
    }
}
