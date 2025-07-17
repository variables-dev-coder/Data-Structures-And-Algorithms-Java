package Arrays.DSA_Counting_Sort;


// Sort Grades A–F (Letter Based)

public class SortGrades {
    public static void main(String[] args) {
        char[] grades = {'C', 'A', 'B', 'A', 'F', 'B', 'C'};
        int[] count = new int[6]; // A-F => index 0-5

        for (char g : grades) {
            count[g - 'A']++;
        }

        for (int i = 0; i < 6; i++) {
            while (count[i]-- > 0) {
                System.out.print((char)(i + 'A') + " ");
            }
        }
    }
}
