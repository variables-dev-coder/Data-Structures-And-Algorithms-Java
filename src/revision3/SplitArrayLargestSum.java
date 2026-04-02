package revision3;

public class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int k) {

        int low = 0, high = 0;

        // Define search space
        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num;              // total sum
        }

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                answer = mid;
                high = mid - 1; // try smaller max
            } else {
                low = mid + 1;  // need bigger max
            }
        }

        return answer;
    }

    private static boolean canSplit(int[] nums, int k, int maxSum) {

        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {

            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                subarrays++;
                currentSum = num;

                if (subarrays > k) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {7,2,5,10,8};
        int k = 2;

        int result = splitArray(nums, k);

        System.out.println("Minimum Largest Sum: " + result);
    }
}
