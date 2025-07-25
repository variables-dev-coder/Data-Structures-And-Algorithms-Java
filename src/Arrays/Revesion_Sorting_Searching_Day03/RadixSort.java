package Arrays.Revesion_Sorting_Searching_Day03;

public class RadixSort {
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i : arr) if (i > max) max = i;
        return max;
    }

    public static void countSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];

        for (int i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = (arr[i] / exp) % 10;
            output[--count[idx]] = arr[i];
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];

    }

    public static void main(String[] args) {
        int[] arr = {170, 50, 80, 700, 12, 3, 90};
        radixSort(arr);
        for (int num : arr)
            System.out.print(num + " ");

    }
}
