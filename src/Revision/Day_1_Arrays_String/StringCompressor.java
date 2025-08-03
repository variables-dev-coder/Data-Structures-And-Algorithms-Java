package Revision.Day_1_Arrays_String;

public class StringCompressor {
    public static int compress(char[] chars) {
        int index = 0, i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            chars[index++] = currentChar;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len = compress(input);
        System.out.print("Compressed: ");
        for (int i = 0; i < len; i++) {
            System.out.print(input[i]);
        }
        System.out.println(); // Output: a2b2c3
    }
}
