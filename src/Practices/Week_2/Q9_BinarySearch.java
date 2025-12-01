package Practices.Week_2;

public class Q9_BinarySearch {
    public static int search(int[] arr, int target) {
        int l=0, r=arr.length-1;

        while (l <= r) {
            int mid = (l+r)/2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(search(a, 4));  // 3
    }
}
