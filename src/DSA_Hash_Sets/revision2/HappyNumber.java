package DSA_Hash_Sets.revision2;

import java.util.*;

public class HappyNumber {

    public static boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {

            if (seen.contains(n)) return false;
            seen.add(n);

            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }

            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
