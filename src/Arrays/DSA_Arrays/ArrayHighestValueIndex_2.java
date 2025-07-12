package Arrays.DSA_Arrays;

public class ArrayHighestValueIndex_2 {
    public static void main(String[] args) {
        int[] arr = {45, 23, 67, 12, 78};
        int maxValue = arr[0];
        int maxIndex = 0;
        int index = 0;

        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
                maxIndex = index;
            }
            index++;
        }
        System.out.println("Maximum Value: " + maxValue);
        System.out.println("Maximum value Index No: " + index);
    }
}
