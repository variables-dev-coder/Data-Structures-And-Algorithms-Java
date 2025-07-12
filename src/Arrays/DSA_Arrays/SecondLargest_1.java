package Arrays.DSA_Arrays;

public class SecondLargest_1 {
    public static void main(String[] args) {
        int[] arr = {45, 23, 67, 12, 78};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No Second largest value (all element may be equal");
        } else {
            System.out.println("Second Largest Value: " + secondLargest);
        }
    }
}
