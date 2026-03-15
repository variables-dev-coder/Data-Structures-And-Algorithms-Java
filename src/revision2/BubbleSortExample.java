package revision2;

import java.util.*;

public class BubbleSortExample {

    static void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = {5,1,4,2,8};

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
