package Arrays.revision;

import java.util.Arrays;

public class MoveZerosDemo {

    public static void moveZeroes(int[] nums) {

        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};

        moveZeroes(arr);
        System.out.println("After moving zeros: " + Arrays.toString(arr));
    }
}

