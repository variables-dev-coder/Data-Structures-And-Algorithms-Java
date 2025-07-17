package Arrays.DSA_Counting_Sort;


// Sort Ages of People Between 1 to 100

public class SortAges {
    public static void main(String[] args) {
        int[] ages = {21, 30, 18, 25, 21, 30, 18, 100, 1};
        int max = 100;
        int[] count = new int[max + 1];

        for (int age : ages) {
            count[age]++;
        }

        for (int i = 0; i <= max; i++) {
            while (count[i]-- > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
