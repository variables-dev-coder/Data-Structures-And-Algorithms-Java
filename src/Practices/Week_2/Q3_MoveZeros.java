package Practices.Week_2;

public class Q3_MoveZeros {
    public static void moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,1,0,3,12};
        moveZeroes(a);
        for (int x : a) System.out.print(x+" ");
    }
}

//1 3 12 0 0