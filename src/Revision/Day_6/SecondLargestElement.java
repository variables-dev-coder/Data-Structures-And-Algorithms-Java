package Revision.Day_6;

public class SecondLargestElement {

    public static Integer findSecondLargest(int[] arr) {
        if (arr.length < 2) return null;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num != largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE || largest == secondLargest) {
            return null;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 8};

        Integer result = findSecondLargest(arr);

        if (result == null) {
            System.out.println("No second largest exists");
        } else {
            System.out.println("Second Largest = " + result);
        }
    }
}

// Second Largest = 10