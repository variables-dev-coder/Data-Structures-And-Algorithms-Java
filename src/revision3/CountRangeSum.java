package revision3;

public class CountRangeSum {

    public static int countRangeSum(int[] nums, int lower, int upper) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private static int mergeSort(long[] arr, int left, int right, int lower, int upper) {

        if (left >= right) return 0;

        int mid = (left + right) / 2;

        int count = mergeSort(arr, left, mid, lower, upper)
                + mergeSort(arr, mid + 1, right, lower, upper);

        int j = mid + 1, k = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (k <= right && arr[k] - arr[i] < lower) k++;
            while (j <= right && arr[j] - arr[i] <= upper) j++;

            count += (j - k);
        }

        // Merge step
        long[] temp = new long[right - left + 1];
        int i = left, p = mid + 1, idx = 0;

        while (i <= mid && p <= right) {
            if (arr[i] <= arr[p]) temp[idx++] = arr[i++];
            else temp[idx++] = arr[p++];
        }

        while (i <= mid) temp[idx++] = arr[i++];
        while (p <= right) temp[idx++] = arr[p++];

        System.arraycopy(temp, 0, arr, left, temp.length);

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 5, -1};
        int lower = -2, upper = 2;

        int result = countRangeSum(nums, lower, upper);

        System.out.println("Count of Range Sum: " + result);
    }
}
