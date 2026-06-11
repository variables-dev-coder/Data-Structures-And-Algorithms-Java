package revision9;

import java.util.HashSet;

public class HappyNumber {

    public static int squareSum(int n){

        int sum = 0;

        while(n > 0){

            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        int n = 19;

        HashSet<Integer> visited = new HashSet<>();

        while(n != 1 && !visited.contains(n)){

            visited.add(n);
            n = squareSum(n);
        }

        System.out.println(n == 1);
    }
}
