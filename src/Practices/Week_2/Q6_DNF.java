package Practices.Week_2;

public class Q6_DNF {
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int t = arr[low]; arr[low] = arr[mid]; arr[mid] = t;
                low++; mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int t = arr[high]; arr[high] = arr[mid]; arr[mid] = t;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        sortColors(a);
        for (int x : a) System.out.print(x+" ");
    }
}

// 0 0 1 1 2 2