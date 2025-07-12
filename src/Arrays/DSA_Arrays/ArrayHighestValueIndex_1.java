package Arrays.DSA_Arrays;

public class ArrayHighestValueIndex_1 {
    public static void main(String[] args) {
        int[] arrays = {67, 100, 46, 223, 90, 123, 59, 45376,899,4156,8349};
        int maxValue = arrays[0];
        int maxIndex = 0;
        int index = 0;

        for (int value : arrays) {
            if (value > maxValue) {
                maxValue = value;
                maxIndex = index;
            }
            index++;
        }
        System.out.println("Maximum Value: " + maxValue);
        System.out.println("Maximum value index No: " + index);
    }
}
