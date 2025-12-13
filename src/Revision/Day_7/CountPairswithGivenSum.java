package Revision.Day_7;

public class CountPairswithGivenSum {

    static int countPairs(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {

                // Case 1: Same elements
                if (arr[left] == arr[right]) {
                    int n = right - left + 1;
                    count += (n * (n - 1)) / 2;
                    break;
                }

                // Case 2: Different elements
                int leftVal = arr[left];
                int rightVal = arr[right];
                int leftCount = 0, rightCount = 0;

                while (left <= right && arr[left] == leftVal) {
                    leftCount++;
                    left++;
                }

                while (left <= right && arr[right] == rightVal) {
                    rightCount++;
                    right--;
                }

                count += leftCount * rightCount;

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 5, 5, 7};
        int target = 6;

        System.out.println(countPairs(arr, target));
    }
}
