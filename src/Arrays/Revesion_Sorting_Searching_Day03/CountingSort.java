package Arrays.Revesion_Sorting_Searching_Day03;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int max = 0;
        for (int num : arr) if (num > max) max = num;

        int[] count = new int[max + 1];
        for (int num : arr) count[num]++;

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i]--> 0)
                arr[index++] = i;
        }
        for (int num : arr)
            System.out.print(num + " ");
    }
}
