package Arrays.DSA_Linear_Searc;

public class LinearSearch_1 {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 5};
        int targetVal = 5;

        int result = linearSearch(arr, targetVal);

        if (result != -1) {
            System.out.println("Value " + targetVal + " Found at index " + result);
        } else {
            System.out.println("Value " + targetVal + " not Fount");
        }
    }

    public static int linearSearch(int[] arr, int targetVal) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == targetVal) {
                return i;
            }
        }
        return -1;
    }
}
