package Arrays.DSA_Arrays;

public class SecondLargest_2 {
    public static void main(String[] args) {
        int[] arrays = {183, 45, 476, 18, 90, 37};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arrays) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest value (all elements may be equals)");
        } else {
            System.out.println("Second largest Value : " + secondLargest);
        }
    }
}
