package Arrays.DSA_Arrays;

public class LowestValue_3 {
    public static void main(String[] args) {
        int[] arrays = {1, 34, 12, 56, 11, 70};
        int lowestVal = arrays[0];

        for (int i : arrays) {
            if (i < lowestVal) {
                lowestVal = i;
            }
        }
        System.out.println("Lowest Value: " + lowestVal);
    }
}
