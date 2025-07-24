package Arrays.Revesion_Sorting_Searching_Day02;

public class SelectionSortDescending {
    public static void main(String[] args) {
        int[] arr = {20, 10, 14, 35, 12};

        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIdx])
                    maxIdx = j;
            }

            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }
        for (int num : arr)
            System.out.print(num  + " ");
    }
}
