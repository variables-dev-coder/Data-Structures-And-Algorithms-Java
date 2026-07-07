package revision13;

import java.util.HashSet;

public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> set = new HashSet<>();

        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }
}
