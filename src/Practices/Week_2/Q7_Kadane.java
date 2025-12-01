package Practices.Week_2;

public class Q7_Kadane {
    public static int maxSubArray(int[] arr) {
        int max = arr[0], sum = 0;

        for (int x : arr) {
            sum += x;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));   // 6
    }
}
