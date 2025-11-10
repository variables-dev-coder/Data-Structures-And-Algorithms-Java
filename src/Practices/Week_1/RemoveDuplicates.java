package Practices.Week_1;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 1, 2, 2, 2, 3, 4, 4, 5};

        System.out.println("Original array: " + Arrays.toString(sortedArray));

        int newLength = removeDuplicates(sortedArray);
        System.out.println("Length after removing duplicates: " + newLength);

        System.out.print("Array after removal: [");
        for (int i = 0; i < newLength; i++) {
            System.out.print(sortedArray[i] + (i < newLength - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}


//Original array: [1, 1, 2, 2, 2, 3, 4, 4, 5]
//Length after removing duplicates: 5
//Array after removal: [1, 2, 3, 4, 5]