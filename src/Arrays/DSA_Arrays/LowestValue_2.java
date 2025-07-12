package Arrays.DSA_Arrays;

public class LowestValue_2 {
    public static void main(String[] args) {
        int[] arr = {56, 12, 23, 67, 90};
        int lowest = arr[0];

        for (int i : arr) {
            if (i < lowest) {
                lowest = i;
            }
        }
        System.out.println("Lowest Value : " + lowest);
    }
}
